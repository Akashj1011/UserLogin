package com.example.userlogin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
 
@Entity

@NamedQuery(name = "User.getUserInfo",
        query = "SELECT e FROM User e WHERE username =?1 "
)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;

    private String username;
    private String password;
 
    public User() {
    }
 
    public User(Integer userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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
}