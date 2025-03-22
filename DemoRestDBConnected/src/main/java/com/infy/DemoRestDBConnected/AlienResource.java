package com.infy.DemoRestDBConnected;

import java.util.List;

import com.infy.DemoRestDBConnected.entity.Alien;
import com.infy.DemoRestDBConnected.repo.AlienRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

	
	AlienRepository alienrepo = new AlienRepository();
	
	// http://localhost:8080/DemoRestDBConnected/webapi/aliens
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAllAliens(){
		return alienrepo.getAllAliens();
	}
	
	// http://localhost:8080/DemoRestDBConnected/webapi/aliens/addAlien
	@POST
	@Path("addAlien")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien addAlien(Alien a1) {
		alienrepo.createAlien(a1);
		return a1;
	}
	
	// http://localhost:8080/DemoRestDBConnected/webapi/aliens/alien/{id}
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlienById(@PathParam("id") Long id) {
		return alienrepo.getAlienForId(id);
	}
	
	// http://localhost:8080/DemoRestDBConnected/webapi/aliens/update
	
	@PUT
	@Path("update")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien update(Alien a2) {
		if(alienrepo.getAlienForId(a2.getId())==null) {
			alienrepo.createAlien(a2);
		}
		else {
			alienrepo.update(a2);
		}
		
		return a2;
	}
	
	@DELETE
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien killAlien(@PathParam("id") Long id) {
		Alien a1 = alienrepo.getAlienForId(id);
		if(a1.getId() != 0) {
			alienrepo.delete(id);
		}
		return a1;
	}
	

}
