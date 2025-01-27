package com.kimlog.api.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PagingResponse<T> {

    private final long page;
    private final long size;
    private final long totalCount;
    private final List<T> items;

    public PagingResponse(Page<?> page, Class<T> clazz) {
        // page.getNumber()는 0부터 시작하므로 1을 더해서 1부터 시작하는 페이지 번호로 변환
        this.page = page.getNumber() + 1;
        this.size = page.getSize(); //페이지당 항목 수
        this.totalCount = page.getTotalElements();
        this.items = page.getContent().stream()
                //각 content를 새로운 타입 T로 변환
                .map(content -> {
                    try {
                        // 리플렉션을 사용하여:
                        // 1. content의 클래스 타입을 파라미터로 받는 생성자를 찾고
                        // 2. 그 생성자를 사용해 새 인스턴스를 생성
                        return clazz.getConstructor(content.getClass()).newInstance(content);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
