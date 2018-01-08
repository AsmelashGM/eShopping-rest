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
import javax.ws.rs.core.MediaType;

import dev.controller.AdministratorController;
import dev.model.Administrator;

@Path("admins")
public class AdministratorResource {
	AdministratorController administratorController = new AdministratorController();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Administrator> getAdministrators() {
		List<Administrator> admins = new ArrayList<Administrator>();
		admins = administratorController.getAllAdministrators();
		return admins;
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Administrator getAdministrator(@PathParam("username") String username) {
		return administratorController.getAdministrator(username);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addAdministrator(Administrator admin) {
		return administratorController.addAdministrator(admin);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateAdministrator(Administrator admin) {
		return administratorController.updateAdministrator(admin);
	}

	@DELETE
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAdministrator(@PathParam("username") String username) {
		return administratorController.removeAdministrator(username);
	}
}

