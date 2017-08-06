package com.ssm.dto;

public class Admin {
	private Integer user_id;
	private Integer ec_salt;
	private Integer role_id;
	private String user_name;
	private String email;
	private String password;
	private String add_time;
	private String last_login;
	private String last_ip;
	private String action_list;
	private String nav_list;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getEc_salt() {
		return ec_salt;
	}
	public void setEc_salt(Integer ec_salt) {
		this.ec_salt = ec_salt;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	public String getAction_list() {
		return action_list;
	}
	public void setAction_list(String action_list) {
		this.action_list = action_list;
	}
	public String getNav_list() {
		return nav_list;
	}
	public void setNav_list(String nav_list) {
		this.nav_list = nav_list;
	}
	@Override
	public String toString() {
		return "Admin [user_id=" + user_id + ", ec_salt=" + ec_salt + ", role_id=" + role_id + ", user_name="
				+ user_name + ", email=" + email + ", password=" + password + ", add_time=" + add_time + ", last_login="
				+ last_login + ", last_ip=" + last_ip + ", action_list=" + action_list + ", nav_list=" + nav_list + "]";
	}
	
}
