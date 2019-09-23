package com.greatlearning.twitterapp.client;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.greatlearning.twitterapp.controller.UserController;
import com.greatlearning.twitterapp.model.Tweet;
import com.greatlearning.twitterapp.model.User;

public class Client {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        UserController controller = (UserController) applicationContext.getBean(UserController.class);
        
        User user1 = new User(1,"ram");
        user1.setDateOfBirth(LocalDate.of(2012, 12,12));
        
        Tweet tweet = new Tweet();
        tweet.setMessage("welcome twitter");
        tweet.setCreatedDate(LocalDate.now());
        
        Tweet tweet2 = new Tweet();
        tweet2.setMessage("Hello world!");
        tweet2.setCreatedDate(LocalDate.now());

        user1.addTweet(tweet);
        user1.addTweet(tweet2);

        User user2 = new User(2,"raj");
        User user3 = new User(3,"sri");
        User user4 = new User(4,"raghu");

        user1.addFollower(user2);
        user1.addFollower(user3);
        user2.addFollower(user1);

        controller.saveUser(user1);
        //find
        controller.find(1);
        controller.getAllTweets(1);

        
	}

}
