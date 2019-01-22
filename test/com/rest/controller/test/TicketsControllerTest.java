package com.rest.controller.test;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

import com.domain.Ticket;

import junit.framework.Assert;

public class TicketsControllerTest {

	@Test
	public void testGetTicketsForRoute() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target("http://localhost:8090/TicketManagementModule/tickets/book?from=Mumbai&to=Karjat");
		Response response = target.request().get();
		try {
			Assert.assertEquals(200, response.getStatus());
			Ticket ticket = response.readEntity(Ticket.class);
			Assert.assertEquals("from",ticket.getFrom() );
		} finally {
			response.close();
			client.close();
		}
	}

}
