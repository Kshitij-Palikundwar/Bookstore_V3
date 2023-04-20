package com.cts.idp.service;

import java.util.List;

import com.cts.idp.exceptions.UserNotFoundException;
import com.cts.idp.model.User;

public interface UserService {

	public User create(User user);

	public List<User> findAll();

	public User findById(int id) throws UserNotFoundException;

	public void deleteById(int id)throws UserNotFoundException;
}
