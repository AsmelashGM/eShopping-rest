package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.Customer;

public class CustomerController {
	private static Map<String, Customer> customers = DataMapper.getCustomers();

	public CustomerController(){
		customers.put("asm", new Customer("asm", "Asmelash", "KTH, Stockholm, Sweden", 
				"asm@eshoping.dev", "12348980870, Nordea", "Kiyer 12 lgh 1230"));
		customers.put("tes", new Customer("tes", "Tesfay", "Stockholm, Sweden", 
				"tes@eshoping.dev", "876544677777, ICABanken", "Minuo 02 lgh 1102"));
		customers.put("guest", new Customer("guest", "Midaqua", "Solna, Sweden", 
				"guest@eshoping.dev", "084574640980, SEB", "Kungs 87 lgh 1010"));
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> list = new ArrayList<>(customers.values());
		return list;
	}
	
	public List<Customer> getAllCustomers(String q){
		List<Customer> list = new ArrayList<>();
		q = q.toLowerCase();
		for(Customer customer: customers.values()) {
			if(customer.getName().toLowerCase().contains(q)) {
				list.add(customer);
			}
		}
		return list;
	}
	
	public List<Customer> getAllCustomers(int start, int size){
		List<Customer> list = new ArrayList<>(customers.values());
		if(start > list.size() - 1)
			return new ArrayList<Customer>();
		else if(start + size > list.size())
			return list.subList(start, list.size());
		else
			return list.subList(start, start + size);
	}
	
	public Customer getCustomer(String uname) {
		return customers.get(uname);
	}
	
	public String addCustomer(Customer customer) {
		customers.put(customer.getUsername(), customer);
		return "Customer successfully added!";
	}
	
	public String updateCustomer(Customer customer) {
		if(customer.getUsername() == null) {
			return "Customer is not updated!";
		}
		customers.put(customer.getUsername(), customer);
		return "Customer successfully updated!";
	}
	
	public String removeCustomer(String uname) {
		customers.remove(uname);
		return "Customer successfully removed!";
	}
}