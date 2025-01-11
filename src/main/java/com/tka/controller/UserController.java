package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.service.UserService;

@Controller
public class UserController {
	public UserController() {
		System.err.println("In UserController");
	}

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String openLoginPage() {
		return "login"; // return to view resolver
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
		boolean isLogedIn = service.loginUser(username, password);
		if (isLogedIn) {
			return "menu";
		} else {
			model.addAttribute("msg", "Invalid Credientials");
			return "login";
		}
	}
	

}
