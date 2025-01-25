package com.kimlog.api.repository.post;

import com.kimlog.api.domain.Post;
import com.kimlog.api.request.post.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}

