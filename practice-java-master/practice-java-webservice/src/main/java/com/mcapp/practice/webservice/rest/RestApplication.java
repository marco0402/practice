package com.mcapp.practice.webservice.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RestApplication extends ResourceConfig {
	public RestApplication() {
		packages("com.mcapp.practice.webservice.rest");
	}
}
