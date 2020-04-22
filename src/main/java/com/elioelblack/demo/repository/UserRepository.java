/**
 * 
 */
package com.elioelblack.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elioelblack.demo.model.User;

/**
 * @author eliezer
UserRepository.java *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByIdAndPassword(Long id, String password);

}
