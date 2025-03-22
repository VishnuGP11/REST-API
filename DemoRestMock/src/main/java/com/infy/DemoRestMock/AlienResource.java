package com.infy.DemoRestMock;

import java.util.List;

import com.infy.DemoRestMock.repo.AlienRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienRepository alienrepo = new AlienRepository();
	
	
	// http://localhost:8080/DemoRestMock/webapi/aliens
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAlien() {
		
		return alienrepo.getAliens();
	}
	
	
	// http://localhost:8080/DemoRestMock/webapi/aliens/addAlien
	@POST
	@Path("addAlien")
	public Alien createAlien(Alien a1) {
		alienrepo.create(a1);
		return a1;
	}
	
	// http://localhost:8080/DemoRestMock/webapi/aliens/alien/561
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Alien getAlienUsingId(@PathParam("id") int id ) {
	 return alienrepo.getAlienById(id);
		
	}
	
}
