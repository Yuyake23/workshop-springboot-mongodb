package com.brunosamuel.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.brunosamuel.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
