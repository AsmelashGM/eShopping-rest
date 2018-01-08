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

import dev.controller.ProductController;
import dev.model.Product;

@Path("products")
public class ProductResource {
	ProductController productController = new ProductController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts(@QueryParam("q") String q,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		
		List<Product> products = new ArrayList<Product>();
		if(q != null) {
			products = productController.getAllProducts(q);
			return products;
		}
		if(start >=0 && size > 0) {
			products = productController.getAllProducts(start, size);
			return products;
		}
		//Otherwise, these statements follow 
		products = productController.getAllProducts();
		return products;
	}

	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("productId") long id) {
		return productController.getProduct(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addProduct(Product product) {
		return productController.addProduct(product);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateProduct(Product product) {
		return productController.updateProduct(product);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProduct(@PathParam("id") long id) {
		return productController.removeProduct(id);
	}
}

