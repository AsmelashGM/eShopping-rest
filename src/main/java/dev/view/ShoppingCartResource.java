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

import dev.controller.ShoppingCartController;
import dev.model.ShoppingCart;

@Path("carts")
public class ShoppingCartResource {
	ShoppingCartController shoppingCartController = new ShoppingCartController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShoppingCart> getShoppingCarts(@QueryParam("q") String q,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		if(start >=0 && size > 0) {
			list = shoppingCartController.getAllShoppingCarts(start, size);
			return list;
		}
		//Otherwise, these statements follow 
		list = shoppingCartController.getAllShoppingCarts();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ShoppingCart getShoppingCart(@PathParam("id") long id) {
		return shoppingCartController.getShoppingCart(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addShoppingCart(ShoppingCart product) {
		return shoppingCartController.addShoppingCart(product);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateShoppingCart(ShoppingCart product) {
		return shoppingCartController.updateShoppingCart(product);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteShoppingCart(@PathParam("id") long id) {
		return shoppingCartController.removeShoppingCart(id);
	}
}

