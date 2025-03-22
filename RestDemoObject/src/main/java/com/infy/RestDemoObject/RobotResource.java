package com.infy.RestDemoObject;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("robots")
public class RobotResource {
	
	// returns only a single object details in xml format
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Robot getRobot() {
//		
//		Robot r1 = new Robot();
//		r1.setName("Predator");
//		r1.setSerialNo(8969l);
//		return r1;	
//	}
	
	// used to return list of object details in xml format
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Robot> getRobot() {
		
		
		Robot r1 = new Robot();
		r1.setName("Predator");
		r1.setSerialNo(8969l);
		
		Robot r2 = new Robot();
		r2.setName("Rocky");
		r2.setSerialNo(8943l);
		
		Robot r3 = new Robot();
		r3.setName("Musk");
		r3.setSerialNo(6666l);
		
		List<Robot> robots = Arrays.asList(r1,r2,r3);
		
		return robots;	
	}

}
