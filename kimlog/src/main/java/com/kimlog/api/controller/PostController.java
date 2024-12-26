package com.kimlog.api.controller;

import com.kimlog.api.request.PostCreate;
import com.kimlog.api.request.PostEdit;
import com.kimlog.api.request.PostSearch;
import com.kimlog.api.response.PostResponse;
import com.kimlog.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        //Case1. 저장한 데이터 Entity -> response로 응답하기
        //Case2. 저장한 데이터의 primary_id -> response로 응답하기
                // Client에서는 수신한 id를 글 조회 api를 통해서 데이터를 수신받음
        //Case3. 응답 필요 없음 -> 클라이언트에서 모든 POST(글) 데이터 context를 잘 관리함
        //Bad case: 서버에서 반드시 이렇게 할 것이다와 같이 유연하지 못한 경우
        request.validate();
        postService.write(request);
    }

    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId) {
        return postService.get(postId);
    }

    @GetMapping("/posts")
    public List<PostResponse> getList(@ModelAttribute PostSearch postSearch) {
        return postService.getList(postSearch);
    }

    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        postService.edit(postId, request);
    }

    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
    }
}



