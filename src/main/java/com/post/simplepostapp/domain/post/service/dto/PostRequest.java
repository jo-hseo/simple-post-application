package com.post.simplepostapp.domain.post.service.dto;

import com.post.simplepostapp.domain.post.domain.model.Post;

public record PostRequest (
	String title,
	String content
){
	public Post toEntity() {
		return new Post(title, content);
	}
}
