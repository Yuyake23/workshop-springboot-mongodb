package com.brunosamuel.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosamuel.workshopmongo.dto.UserDTO;
import com.brunosamuel.workshopmongo.entities.User;
import com.brunosamuel.workshopmongo.repositories.UserRepository;
import com.brunosamuel.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public void deleteById(String id) {
		if (!repository.existsById(id))
			throw new ObjectNotFoundException("Object not found");

		repository.deleteById(id);
	}

	public User update(String id, User obj) {
		obj.setId(id);
		User currentUser = findById(id);
		updateData(currentUser, obj);
		return repository.save(currentUser);
	}

	private void updateData(User currentUser, User updatedUser) {
		currentUser.setName(updatedUser.getName());
		currentUser.setEmail(updatedUser.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

}
