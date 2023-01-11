package com.brunosamuel.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunosamuel.workshopmongo.entities.Post;
import com.brunosamuel.workshopmongo.resources.util.URL;
import com.brunosamuel.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitleContaining(
			@RequestParam(defaultValue = "", value = "text") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitleContaining(text);
		return ResponseEntity.ok().body(posts);
	}

}