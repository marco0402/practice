package com.mcapp.practice.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/service")
public class RestResource {
	@GET
	public String defaultService() {
		return "Default Service";
	}
	
	@GET
	@Path("/{serviceName}")
	public String namedService(@PathParam("serviceName") String serviceName) {
		return serviceName + " Service";
	}
}
