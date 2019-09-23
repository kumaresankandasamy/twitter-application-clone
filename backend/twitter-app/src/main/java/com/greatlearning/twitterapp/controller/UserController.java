package com.greatlearning.twitterapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.greatlearning.twitterapp.model.Tweet;
import com.greatlearning.twitterapp.model.User;
import com.greatlearning.twitterapp.service.UserService;

@Component
public class UserController {
	@Autowired
	UserService userservice;
	public User createUser(User user) {
		System.out.println("create user");
		return this.userservice.create(user);
		
	}
	public User saveUser(User user){
        return this.userservice.save(user);
    }
	public void addTweet(long userId, Tweet tweet){
	        this.userservice.addTweet(userId, tweet);
	    }
    public User find(long userId) {
    	return this.userservice.findUser(userId);
    	}
    public Set<Tweet> getAllTweets(long userId){
    	return this.userservice.getAllTweets(userId);
    }
    
	public User follow(long userId,long followingId) {
    	return this.userservice.follow(userId, followingId);  
    }
    public Set<User> getAllFollowers(long userId){
    	return this.userservice.getAllFollowers(userId);
    }
    public Set<User> getAllFollowings(long userId){
    	return this.userservice.getAllFollowings(userId);
    }
	public Object fetchTweetsByUserId(long id) {
		long userId = 0;
		return this.userservice.getAllTweets(userId);
	}
}
