/**
 * 
 */
package com.elioelblack.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elioelblack.demo.model.User;
import com.elioelblack.demo.repository.RoleRepository;
import com.elioelblack.demo.service.UserService;

/**
 * @author eliezer
 *
 */
@Controller
public class UserController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/userForm")
	public String getUserForm(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("listTab","active");
		return "user-form/user-view";
	}
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
}
