package dev.view;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.controller.CustomerController;
import dev.model.Customer;

@Path("customers")
public class CustomerResource {
	CustomerController customerController = new CustomerController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers(@QueryParam("q") String q,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		
		List<Customer> list = new ArrayList<Customer>();
		if(q != null) {
			list = customerController.getAllCustomers(q);
			return list;
		}
		if(start >=0 && size > 0) {
			list = customerController.getAllCustomers(start, size);
			return list;
		}
		//Otherwise, these statements follow 
		list = customerController.getAllCustomers();
		return list;
	}

	@GET
	@Path("/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("customerId") String customerId) {
		return customerController.getCustomer(customerId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCustomer(Customer customer) {
		return customerController.addCustomer(customer);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateCustomer(Customer customer) {
		return customerController.updateCustomer(customer);
	}

	@DELETE
	@Path("/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCustomer(@PathParam("customerId") String customerId) {
		return customerController.removeCustomer(customerId);
	}
}

