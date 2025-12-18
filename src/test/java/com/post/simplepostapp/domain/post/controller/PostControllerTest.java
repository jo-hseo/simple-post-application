package com.post.simplepostapp.domain.post.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.post.simplepostapp.domain.post.service.PostService;
import com.post.simplepostapp.domain.post.service.dto.PostRequest;

@WebMvcTest(controllers = PostController.class)
class PostControllerTest {
	@MockitoBean
	private PostService postService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("포스트 등록")
	void createPost() throws Exception {
		//given
		PostRequest request = new PostRequest("제목", "내용");
		String content = objectMapper.writeValueAsString(request);

		//when - then
		mockMvc.perform(MockMvcRequestBuilders.post("/posts")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@DisplayName("포스트 조회")
	void getPost() throws Exception {

		//when - then
		mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());

	}
}