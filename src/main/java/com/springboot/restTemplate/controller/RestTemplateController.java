package com.springboot.restTemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restTemplate.model.Theater;
import com.springboot.restTemplate.model.TheaterDetailsDTO;
import com.springboot.restTemplate.service.RestTemplateService;

@RestController
@RequestMapping("/restTemplate")
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService restService;
	
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

}}
