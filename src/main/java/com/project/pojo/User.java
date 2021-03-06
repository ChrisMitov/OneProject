package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.enums.UserRole;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User() {
    }

    public User(String username, String password, UserRole role) {

        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getIdUser() {
        return id;
    }

    public void setIdUser(Integer id) {
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
