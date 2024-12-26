package com.kimlog.api.repository;

import com.kimlog.api.domain.Post;
import com.kimlog.api.request.PostSearch;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kimlog.api.domain.QPost.post;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getList(PostSearch postSearch) {
        return jpaQueryFactory.selectFrom(post)
                .limit(postSearch.getSize())  //가져올 데이터의 최대 갯수
                .offset(postSearch.getOffset()) //건너뛸 데이터의 갯수
                .orderBy(post.id.desc()) //id를 기준으로 내림차순 정렬
                .fetch();
    }
}