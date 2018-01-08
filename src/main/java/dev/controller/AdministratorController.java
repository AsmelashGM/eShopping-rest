package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.Administrator;

public class AdministratorController {
	private static Map<String, Administrator> admins = DataMapper.getAdministrators();

	public AdministratorController(){
		admins.put("admin", new Administrator("admin", "admin","admin@eshoping.dev"));
	}
	
	public List<Administrator> getAllAdministrators(){
		List<Administrator> list = new ArrayList<>(admins.values());
		return list;
	}
	
	public Administrator getAdministrator(String username) {
		return admins.get(username);
	}
	
	public String addAdministrator(Administrator admin) {
		admins.put(String.valueOf(admin.getUsername()), admin);
		return "Administrator successfully added!";
	}
	
	public String updateAdministrator(Administrator admin) {
		if(admin.getUsername() == null) {
			return "Administrator is not updated!";
		}
		admins.put(String.valueOf(admin.getUsername()), admin);
		return "Administrator successfully updated!";
	}
	
	public String removeAdministrator(String username) {
		admins.remove(username);
		return "Administrator successfully removed!";
	}
}