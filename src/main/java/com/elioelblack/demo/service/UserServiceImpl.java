/**
 * 
 */
package com.elioelblack.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elioelblack.demo.model.User;
import com.elioelblack.demo.repository.UserRepository;
import com.elioelblack.demo.service.UserService;
/**
 * @author eliezer
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<User> getAllUsers() {		
		return repository.findAll();
	}

}
