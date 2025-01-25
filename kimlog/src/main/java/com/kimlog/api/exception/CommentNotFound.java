package com.kimlog.api.exception;

/**
 * status -> 404
 */
public class CommentNotFound extends KimlogException {

    private static final String MESSAGE = "존재하지 않는 댓글입니다.";

    public CommentNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
