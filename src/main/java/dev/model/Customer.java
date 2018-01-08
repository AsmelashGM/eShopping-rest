package dev.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private String username;
    private String name;
    private String email;
    private String address;
    private String creditcardinfo;
    private String shippinginfo;
    
    public Customer() {}
	public Customer(String username, String name, String address, String email, String creditcardinfo,
			String shippinginfo) {
		this.username = username;
		this.name = name;
		this.address = address;
		this.email = email;
		this.creditcardinfo = creditcardinfo;
		this.shippinginfo = shippinginfo;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreditcardinfo() {
		return creditcardinfo;
	}
	public void setCreditcardinfo(String creditcardinfo) {
		this.creditcardinfo = creditcardinfo;
	}
	public String getShippinginfo() {
		return shippinginfo;
	}
	public void setShippinginfo(String shippinginfo) {
		this.shippinginfo = shippinginfo;
	}
}
