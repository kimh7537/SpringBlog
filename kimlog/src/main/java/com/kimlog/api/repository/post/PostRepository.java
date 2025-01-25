package com.kimlog.api.repository.post;

import com.kimlog.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

}
