package com.kimlog.api.controller;

import com.kimlog.api.request.comment.CommentCreate;
import com.kimlog.api.request.comment.CommentDelete;
import com.kimlog.api.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/posts/{postId}/comments")
    public void write(@PathVariable Long postId, @RequestBody @Valid CommentCreate request) {
        commentService.write(postId, request);
    }

    @PostMapping("/api/comments/{commentId}/delete")
    public void delete(@PathVariable Long commentId, @RequestBody @Valid CommentDelete request) {
        commentService.delete(commentId, request);
    }
}

