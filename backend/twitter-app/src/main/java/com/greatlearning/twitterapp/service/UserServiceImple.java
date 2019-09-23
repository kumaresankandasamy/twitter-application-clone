package com.greatlearning.twitterapp.service;



import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.twitterapp.exception.InvaildUserException;
import com.greatlearning.twitterapp.model.Tweet;
import com.greatlearning.twitterapp.model.User;
import com.greatlearning.twitterapp.repository.TweetRepository;
import com.greatlearning.twitterapp.repository.UserRepository;

@Service
@Transactional
public class UserServiceImple implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    TweetRepository tweetRepository;
	@Override
	public User create(User user) {
		
		return (User) this.userRepository.save(user);
	}

	@Override
	public User save(User user) {
		
		return (User) this.userRepository.save(user);
	}

	@Override
	public User findUser(long userId) {
		Optional<User> optionalUser = this.userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}

	@Override
	public Tweet addTweet(long userId, Tweet tweet) {
		
		Optional<User> userOptional = this.userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
             user.addTweet(tweet);
        }
		return tweet;
		
	}

	@Override
	public Tweet deleteTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Tweet> getAllTweets(long userId) {
		Optional<User> userOptional = this.userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return user.getTweets();
        }
        return null;
	}

	@Override
	public User follow(long userId, long followingId) {
		User user = null;
		try {
			user = validUser(userId);
		} catch (InvaildUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.addFollower(user);;
		return user;
	}

	@Override
	public Set<User> getAllFollowings(long userId) {
		Optional<User> userOptional = this.userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getFollowings();
        }
        return null;
	}

	@Override
	public User unFollow(long UserId, long followingId) {
		long userId = 0;
		User user = null;
		try {
			user = validUser(userId);
		} catch (InvaildUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.removeUser(user);
		return user;
		
	}

	@Override
	public Set<User> getAllFollowers(long userId) {
		 Optional<User> userOptional = this.userRepository.findById(userId);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            return user.getFollowers();
	        }
	        return null;

	}
	@Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

	@Override
	public User updateUser(User user){
	   this.userRepository.save(user);
	   return user;
	}

	@Override
	public User deleteUser(long userId) {
		User user = null;
		try {
			user = validUser(userId);
		} catch (InvaildUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userRepository.delete(user);
		return user;
		}
	private User validUser(long userId) throws InvaildUserException {
		Optional<User> user = this.userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new InvaildUserException();
		}
}

}
