package com.springboot.restTemplate.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theater {
	
	@Id
	private Long id;
	   public Theater(Long id, String name, String location, int totalSeats, int availableSeats) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
	}
	private String name; 
	   private String location; 
	   private int totalSeats; 
	   private int availableSeats;
	   public Theater() {
	        // No-arg constructor
	    }
	   @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Movie> movies = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public void addMovie(Movie movie) {
        movies.add(movie);
        movie.setTheater(this);
    }
    
    public void removeMovie(Movie movie) {
        movies.remove(movie);
        movie.setTheater(null);
    }
	@Override
	public String toString() {
		return "Theater [id=" + id + ", name=" + name + ", location=" + location + ", totalSeats=" + totalSeats
				+ ", availableSeats=" + availableSeats + "]";
	} 

}
