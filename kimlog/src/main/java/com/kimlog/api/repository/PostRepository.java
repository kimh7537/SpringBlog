package com.kimlog.api.repository;

import com.kimlog.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
