package com.springboot.restTemplate.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.restTemplate.controller.RestTemplateController;
import com.springboot.restTemplate.model.Theater;
import com.springboot.restTemplate.model.TheaterDetailsDTO;

@Service
public class RestTemplateService {
	
	//it allows to make a http request to movie ticket application server
	@Autowired
	private RestTemplate restTemplate;
	
	//MOVIE TICKET APPLICATION URL 
	   private final String MOVIE_TICKET_URL = "http://localhost:9090/bookmyshow"; // URL for Movie Ticket Application
	   public List<Theater> getTheaters(String location) {
	        Theater[] theaters = restTemplate.getForObject(
	            MOVIE_TICKET_URL + "/" + location,
	            Theater[].class
	        );
	        return Arrays.asList(theaters);
	    }

	   public TheaterDetailsDTO getTheaterDetails(String location, String theaterName) {
	        return restTemplate.getForObject(
	            MOVIE_TICKET_URL + "/" + location + "/" + theaterName,
	            TheaterDetailsDTO.class
	        );
	   }
}
