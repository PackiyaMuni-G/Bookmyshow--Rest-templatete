package com.springboot.restTemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restTemplate.model.Booking;
import com.springboot.restTemplate.model.Theater;
import com.springboot.restTemplate.model.TheaterDetailsDTO;
import com.springboot.restTemplate.service.RestTemplateService;

@RestController
@RequestMapping("/restTemplate")
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService restService;
	
	
	 @GetMapping("/getAllTheaters")
	    public ResponseEntity<List<Theater>> getAllTheaters() {
	        List<Theater> theaters = restService.getAllTheaters();
	        return ResponseEntity.ok(theaters);
	    }
	
	 @GetMapping(value = "/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Theater>> getTheatersByLocation(@PathVariable String location) {
	        List<Theater> theaters = restService.getTheaters(location);
	        return ResponseEntity.ok(theaters);
	    }
	
	 @GetMapping(value = "/{location}/{theaterName}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TheaterDetailsDTO> getTheaterDetails(@PathVariable String location, 
	                                                              @PathVariable String theaterName) {
	        TheaterDetailsDTO theaterDetails = restService.getTheaterDetails(location, theaterName);
	        if (theaterDetails != null) {
	            return ResponseEntity.ok(theaterDetails);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	        
	        

}
	 
	 @PostMapping(value = "/addTheater", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Theater> addTheater(@RequestBody Theater theater) {
	        try {
	            Theater savedTheater = restService.addTheater(theater);
	            return ResponseEntity.ok(savedTheater);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }
	 
	 @PutMapping("/updateTheater/{theaterId}")
	    public ResponseEntity<Theater> updateTheater(@PathVariable Long theaterId, 
	                                                 @RequestBody Theater updatedTheater) {
	        try {
	            Theater theater = restService.updateTheater(theaterId, updatedTheater);
	            return ResponseEntity.ok(theater);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }
	 
	 @DeleteMapping("/deleteTheater/{theaterId}")
	    public ResponseEntity<String> deleteTheater(@PathVariable Long theaterId) {
	        try {
	            restService.deleteTheater(theaterId);
	            return ResponseEntity.ok("Theater with ID " + theaterId + " deleted successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().body("Error occurred while deleting the theater.");
	        }
	    }
	 
	 @PostMapping("/bookTickets")
	    public ResponseEntity<?> bookTickets(
	            @RequestParam Long theaterId,
	            @RequestParam Long movieId,
	            @RequestParam int numberOfSeats) {
	        
	        // Build the URI for the MovieTicket application
	        String bookingUrl = "http://localhost:9090/bookmyshow/bookings/book";

	        // Create the request parameters to be sent to the MovieTicket API
	        String urlWithParams = String.format("%s?theaterId=%d&movieId=%d&numberOfSeats=%d", 
	                                             bookingUrl, theaterId, movieId, numberOfSeats);
	        
	        // Make a POST request to the MovieTicket application
	        try {
	            ResponseEntity<Booking> response = restService.exchange(
	                urlWithParams, 
	                HttpMethod.POST, 
	                null, 
	                Booking.class);

	            if (response.getStatusCode() == HttpStatus.OK) {
	                return ResponseEntity.ok(response.getBody());
	            } else {
	                return ResponseEntity.status(response.getStatusCode())
	                        .body("Error occurred while booking tickets.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Internal server error while making the booking request.");
	        }
	    }

	   
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	 
