package com.post.simplepostapp.domain.post.service;

import org.springframework.stereotype.Service;

import com.post.simplepostapp.domain.post.domain.model.Post;
import com.post.simplepostapp.domain.post.domain.repository.PostRepository;
import com.post.simplepostapp.domain.post.service.dto.PostRequest;
import com.post.simplepostapp.domain.post.service.dto.PostResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public void create(PostRequest request) {
		Post post = request.toEntity();
		postRepository.save(post);
	}

	public PostResponse getPost(Long id) {
		Post post = postRepository.findById(id).orElse(null);
		return PostResponse.of(post);
	}
}
