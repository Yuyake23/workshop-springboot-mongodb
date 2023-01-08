package com.brunosamuel.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.brunosamuel.workshopmongo.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
