package com.kimlog.api.response;

import com.kimlog.api.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 서비스 정책에 맞는 클래스
 */
@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime regDate;

    // 생성자 오버로딩 : 같은 이름의 메서드를 여러 개 정의
    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.regDate = post.getRegDate();
    }
}