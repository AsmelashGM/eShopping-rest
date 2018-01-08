package dev.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Administrator {
	private String username;
    private String name;
    private String email;
    
    public Administrator() {}
	
	public Administrator(String username, String name, String email) {
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
