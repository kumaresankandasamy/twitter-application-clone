package com.greatlearning.twitterapp.service;
import java.util.List;
import java.util.Set;

import com.greatlearning.twitterapp.model.Tweet;
import com.greatlearning.twitterapp.model.User;

public interface UserService {
	User create(User user);
	User save(User user);
	User updateUser(User user);
	User findUser(long userId);
	Tweet addTweet(long userId,Tweet tweet);
	Tweet deleteTweet(Tweet tweet);
	Set<Tweet> getAllTweets(long userId);
	User follow(long userId,long followingId);
	Set<User> getAllFollowings(long userId);
	User unFollow(long UserId,long followingId);
	Set<User> getAllFollowers(long userId);
	List<User> getAllUsers();
	User deleteUser(long userId);
	
	
	
}
