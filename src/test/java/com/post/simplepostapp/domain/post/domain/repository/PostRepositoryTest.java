package com.post.simplepostapp.domain.post.domain.repository;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.post.simplepostapp.domain.post.domain.model.Post;
import com.post.simplepostapp.domain.post.service.dto.PostRequest;
import com.post.simplepostapp.global.config.JpaConfig;

@Import(JpaConfig.class)
@DataJpaTest
class PostRepositoryTest {
	@Autowired
	private PostRepository postRepository;

	@Test
	@DisplayName("포스트 등록")
	void createPost() {
		//given
		PostRequest request = new PostRequest("제목", "내용");

		//when
		Post savedPost = postRepository.save(request.toEntity());

		//then
		assertNotNull(savedPost.getId());
		assertEquals("제목", savedPost.getTitle());
		assertEquals("내용", savedPost.getContent());
		assertNotNull(savedPost.getCreatedAt());
	}

	@Test
	@DisplayName("포스트 조회")
	void getPost() {
		//given
		PostRequest request = new PostRequest("제목", "내용");
		Post savedPost = postRepository.save(request.toEntity());

		//when
		Post findedPost = postRepository.findById(savedPost.getId()).orElse(null);

		//then
		assertNotNull(findedPost);
		assertEquals(savedPost.getId(), findedPost.getId());
	}
}