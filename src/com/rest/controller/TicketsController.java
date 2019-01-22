package com.rest.controller;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.data.Stations;
import com.domain.Ticket;
import com.utils.DateUtils;
import com.utils.TicketsUtils;

@Path("tickets")
public class TicketsController {
	static Logger logger = Logger.getLogger(TicketsController.class.getName());

	@GET
	@Path("book")
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket getTicketsForRoute(@QueryParam("from") Stations from, @QueryParam("to") Stations to,
			@DefaultValue("second") @QueryParam("class") String journeyClass,
			@DefaultValue("single") @QueryParam("type") String journeyType,
			@DefaultValue("true") @QueryParam("confirmed") boolean confirmed) {
		Ticket ticket=new Ticket();
		ticket.setBookingTime(DateUtils.getCurrentTime());
		ticket.setId((int)(Math.random()*100000));
		ticket.setFrom(from.name());
		ticket.setTo(to.name());
		ticket.setJourneyClass(journeyClass);
		ticket.setConfirmed(confirmed);
		ticket.setJourneyType(journeyType);
		ticket.setCost(TicketsUtils.calculateFare(from.ordinal(), to.ordinal()));
		logger.debug("Got the ticket");
		logger.info("info log");
		return ticket;
	}
	
}
