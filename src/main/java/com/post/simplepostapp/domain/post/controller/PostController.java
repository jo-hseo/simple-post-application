package com.post.simplepostapp.domain.post.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.simplepostapp.domain.post.service.PostService;
import com.post.simplepostapp.domain.post.service.dto.PostRequest;
import com.post.simplepostapp.domain.post.service.dto.PostResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@PostMapping
	ResponseEntity<Void> register(@RequestBody PostRequest request) {
		postService.create(request);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
		PostResponse response = postService.getPost(id);
		return ResponseEntity.ok(response);
	}
}
