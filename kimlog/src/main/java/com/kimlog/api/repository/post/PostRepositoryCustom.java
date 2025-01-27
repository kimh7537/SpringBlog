package com.kimlog.api.repository.post;

import com.kimlog.api.domain.Post;
import com.kimlog.api.request.post.PostSearch;
import org.springframework.data.domain.Page;

public interface PostRepositoryCustom {

    Page<Post> getList(PostSearch postSearch);
}

