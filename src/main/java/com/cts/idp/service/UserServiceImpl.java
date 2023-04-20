package com.cts.idp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.idp.dao.UserRepository;
import com.cts.idp.exceptions.UserNotFoundException;
import com.cts.idp.model.User;

@Service 
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User create(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findById(int id) throws UserNotFoundException {
		Optional<User> optional=repo.findById(id);
		if(optional.isEmpty()) {
			throw new UserNotFoundException("User Not Foun With id: " + id);
		}
		return optional.get();
	}

	@Override
	public void deleteById(int id) throws UserNotFoundException {
		User user = findById(id);
		repo.deleteById(id);
		
	}

}
