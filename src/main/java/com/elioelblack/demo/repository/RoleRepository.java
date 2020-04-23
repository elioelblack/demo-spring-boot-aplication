/**
 * 
 */
package com.elioelblack.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elioelblack.demo.model.Role;

/**
 * @author eliezer
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
