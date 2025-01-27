package com.kimlog.api.controller;

import com.kimlog.api.config.UserPrincipal;
import com.kimlog.api.request.post.PostCreate;
import com.kimlog.api.request.post.PostEdit;
import com.kimlog.api.request.post.PostSearch;
import com.kimlog.api.response.PagingResponse;
import com.kimlog.api.response.PostResponse;
import com.kimlog.api.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/api/posts")
    public void post(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody @Valid PostCreate request) {
        postService.write(userPrincipal.getUserId(), request);
    }

    @GetMapping("/api/posts/{postId}")
    public PostResponse get(@PathVariable Long postId) {
        return postService.get(postId);
    }

    @GetMapping("/api/posts")
    public PagingResponse<PostResponse> getList(@ModelAttribute PostSearch postSearch) {
        return postService.getList(postSearch);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/api/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        postService.edit(postId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') && hasPermission(#postId, 'POST', 'DELETE')")
    @DeleteMapping("/api/posts/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
    }
}



