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

import dev.controller.ShippingInfoController;
import dev.model.ShippingInfo;

@Path("shipments")
public class ShippingInfoResource {
	ShippingInfoController shippingInfoController = new ShippingInfoController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShippingInfo> getShippingInfos(@QueryParam("q") String q,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		
		List<ShippingInfo> list = new ArrayList<ShippingInfo>();
		if(q != null) {
			list = shippingInfoController.getAllShippingInfos(q);
			return list;
		}
		if(start >=0 && size > 0) {
			list = shippingInfoController.getAllShippingInfos(start, size);
			return list;
		}
		//Otherwise, these statements follow 
		list = shippingInfoController.getAllShippingInfos();
		return list;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ShippingInfo getShippingInfo(@PathParam("id") long id) {
		return shippingInfoController.getShippingInfo(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addShippingInfo(ShippingInfo product) {
		return shippingInfoController.addShippingInfo(product);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateShippingInfo(ShippingInfo product) {
		return shippingInfoController.updateShippingInfo(product);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteShippingInfo(@PathParam("id") long id) {
		return shippingInfoController.removeShippingInfo(id);
	}
}

