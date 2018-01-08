package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.User;

public class UserController {
	private static Map<String, User> users = DataMapper.getUsers();

	public UserController(){
		users.put("admin", new User("admin", "admin", 1, 1));
		users.put("asm", new User("asm", "asm", 1, 0));
		users.put("tes", new User("tes", "tes", 1, 0));
		users.put("guest", new User("guest", "guest", 1, 0));
	}
	
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<>(users.values());
		return list;
	}
	
	public User getUser(long id) {
		return users.get(String.valueOf(id));
	}
	
	public String addUser(User user) {
		users.put(user.getUsername(), user);
		return "Successfully registered!";
	}
	public String login(User user) {
		User usr =  users.get(user.getUsername());
		if(usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword()))
			return "Success";
		else
			return "Fail";
	}
	
	public String updateUser(User user) {
		if(user.getUsername() == null) {
			return "User info is not updated!";
		}
		users.put(user.getUsername(), user);
		return "User info successfully updated!";
	}
	
	public String removeUser(long id) {
		users.remove(String.valueOf(id));
		return "Successfully deleted!";
	}
}