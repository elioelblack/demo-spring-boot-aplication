/**
 * 
 */
package com.elioelblack.demo.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elioelblack.demo.model.User;
import com.elioelblack.demo.pojo.ChangePasswordForm;
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

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}

	private boolean checkPasswordValid(User user) throws Exception {
		if ( !user.getPassword().equals(user.getConfirmPassword()) || user.getPassword().isEmpty()) {
			throw new Exception("Password y Confirm Password no son iguales");
		}
		return true;
	}


	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			user = repository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		User user = repository.findById(id).orElseThrow(() -> new Exception("User does not exist"));
		return user;
	}

	@Override
	public User updateUser(User user) throws Exception {
		User toUser = getUserById(user.getId());
		mapUser(user, toUser);
		return repository.save(toUser);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from,User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		User user = repository.findById(id)
				.orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));		
		repository.delete(user);
	}

	@Override
	public User changePassword(ChangePasswordForm form) throws Exception {
		User storedUser = repository.findById(form.getId())
				.orElseThrow(()->new Exception("User not foud in ChangePassword - "+getClass().getName()));
		System.out.println("Current="+form.getCurrentPassword()+"  // "
				+ "Guardado = "+storedUser.getPassword());
		if(!form.getCurrentPassword().equals(storedUser.getPassword())) {
			throw new Exception("Current password incorrect");
		}
		if(form.getCurrentPassword().equals(form.getNewPassword())) {
			throw new Exception("New password must be diferent than current password");
		}
		if(!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception("New Password and confirm Password does not match");
		}
		storedUser.setPassword(form.getNewPassword());
		
		return repository.save(storedUser);
	}

}
