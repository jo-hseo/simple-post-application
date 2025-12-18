package com.post.simplepostapp.domain.post.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.simplepostapp.domain.post.domain.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

