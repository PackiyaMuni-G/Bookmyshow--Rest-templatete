package com.springboot.restTemplate.model;

import java.util.List;

public class TheaterDetailsDTO {
    private Long id;
    private String name;
    private String location;
    private int totalSeats;
    private int availableSeats;
    private List
    <Movie> runningMovies;

    // Constructor
    public TheaterDetailsDTO(Long id, String name, String location, 
                           int totalSeats, int availableSeats, List<Movie> runningMovies) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.runningMovies = runningMovies;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public List<Movie> getRunningMovies() { return runningMovies; }
    public void setRunningMovies(List<Movie> runningMovies) { this.runningMovies = runningMovies; }
}

