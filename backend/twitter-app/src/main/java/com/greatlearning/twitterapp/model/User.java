package com.greatlearning.twitterapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Comparable<User>,Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private String userEmail;
	private String firstName;
	private String lastName;
	private int age;
	private LocalDate dob;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Tweet> tweets = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="users_followings",
    joinColumns = @JoinColumn(name="user"),
    inverseJoinColumns = @JoinColumn(name="following"))
	private Set<User> followings = new HashSet<>();
    @ManyToMany(mappedBy="followers",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<User> followers = new HashSet<>();
	public Object removeUser;
    
    User(){}
    

	public User(long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}


	/*public User(String username, String password, String userEmail, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.userEmail = userEmail;
		this.firstName = firstName;
		this.lastName = lastName;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Set<Tweet> tweets) {
		this.tweets = tweets;
	}

	public Set<User> getFollowings() {
		return followings;
	}

	public void setFollowings(Set<User> following) {
		this.followings = following;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
   public int compareTo(User other) {
	   return this.getUsername().compareTo(other.getUsername());
   }

public void addTweet(Tweet tweet) {
	
	this.addTweet(tweet);
	}


public void addFollower(User user2) {
	// TODO Auto-generated method stub
	this.addFollower(user2);
}


public void setDateOfBirth(LocalDate of) {
	this.setDob(dob);
}


public void removeUser(User user) {
	// TODO Auto-generated method stub
	this.removeUser(user);
}

}
