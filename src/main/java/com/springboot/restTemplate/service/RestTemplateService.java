package com.springboot.restTemplate.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.restTemplate.controller.RestTemplateController;
import com.springboot.restTemplate.model.Booking;
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
		   //getForobject => it return  only response  object or bean.
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

	   // Fetch all theaters
	    public List<Theater> getAllTheaters() {
	        Theater[] theaters = restTemplate.getForObject(
	            MOVIE_TICKET_URL + "/getAllTheaters",
	            Theater[].class
	        );
	        return Arrays.asList(theaters);
	    }

	    // Add a new theater
	    public Theater addTheater(Theater theater) {
	        return restTemplate.postForObject(
	            MOVIE_TICKET_URL + "/addTheater",
	            theater,
	            Theater.class
	        );
	    }

	    // Method to update a theater
	    public Theater updateTheater(Long theaterId, Theater updatedTheater) {
	        restTemplate.put(
	            MOVIE_TICKET_URL + "/updateTheater/" + theaterId, 
	            updatedTheater
	        );
	        return updatedTheater; // You can return the updated theater if needed
	    }

		public void deleteTheater(Long theaterId) {
			restTemplate.delete(MOVIE_TICKET_URL + "/deleteTheater/" + theaterId);
			
		}
//exchange () => Flexible customized response type with header and status code
		  public ResponseEntity<Booking> exchange(String urlWithParams, HttpMethod method, 
                  Object requestBody, Class<Booking> responseType) {
// Create an HttpEntity object with the requestBody and headers (if needed)
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON); // Set Content-Type header if required
HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

// Execute the HTTP request
return restTemplate.exchange(urlWithParams, method, entity, responseType);
}
}
