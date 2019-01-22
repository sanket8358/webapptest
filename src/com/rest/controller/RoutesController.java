package com.rest.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.domain.Routes;

@Path("/")
public class RoutesController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Routes> getRoutes(){
		List<Routes> theQuery = sessionFactory.getCurrentSession().createQuery("from routes").list();
		return theQuery;
	}
}
