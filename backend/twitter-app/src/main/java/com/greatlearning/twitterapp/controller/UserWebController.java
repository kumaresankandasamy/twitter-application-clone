package com.greatlearning.twitterapp.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.twitterapp.model.Tweet;
import com.greatlearning.twitterapp.model.User;
import com.greatlearning.twitterapp.service.UserService;

@Controller
public class UserWebController {
	@Autowired
	UserService userService;
	@GetMapping("/")
	public String homepage() {
		System.out.println("welcome page");
		return "welcome";
	}
	@GetMapping("/users")
	public String getAllUsers() {
		Set<User> user = new HashSet<>();
		this.userService.getAllUsers();
		return "users";
		
	}
	@PostMapping
	public String Adduser() {
		User user = null;
		this.userService.save(user);
		return "user";
		
	}
	@GetMapping("/users/{id}/tweets")
	public String getAllTweetsByUserId(@PathVariable("id")long userId,Model model) {
		Set<Tweet> tweets = this.userService.getAllTweets(userId);
		return "tweets";
		
	}
    
}
