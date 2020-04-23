package com.elioelblack.demo.service;

import com.elioelblack.demo.model.User;
import com.elioelblack.demo.pojo.ChangePasswordForm;

public interface UserService {
	public Iterable<User> getAllUsers();
	public User createUser(User formUser) throws Exception;
	public User getUserById(Long id) throws Exception;
	public User updateUser(User user) throws Exception;
	public void deleteUser(Long id)throws Exception;
	public User changePassword(ChangePasswordForm form) throws Exception;
}
