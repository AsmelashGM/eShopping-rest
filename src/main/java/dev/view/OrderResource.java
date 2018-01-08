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

import dev.controller.OrderController;
import dev.model.Order;

@Path("orders")
public class OrderResource {
	
	OrderController orderController = new OrderController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrders(@QueryParam("q") String q,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		
		List<Order> orders = new ArrayList<Order>();
		if(q != null) {
			orders = orderController.getAllOrders(q);
			return orders;
		}
		if(start >=0 && size > 0) {
			orders = orderController.getAllOrders(start, size);
			return orders;
		}
		orders = orderController.getAllOrders();
		return orders;
	}

	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("productId") long id) {
		return orderController.getOrder(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addOrder(Order product) {
		return orderController.addOrder(product);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateOrder(Order product) {
		return orderController.updateOrder(product);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteOrder(@PathParam("id") long id) {
		return orderController.removeOrder(id);
	}
}

