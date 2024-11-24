package com.springboot.restTemplate.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;
    
    private int numberOfSeats;
    private LocalDateTime bookingTime;
    private String status; // CONFIRMED, FAILED
	public Booking(Long id, Movie movie, Theater theater, int numberOfSeats, LocalDateTime bookingTime, String status) {
		super();
		this.id = id;
		this.movie = movie;
		this.theater = theater;
		this.numberOfSeats = numberOfSeats;
		this.bookingTime = bookingTime;
		this.status = status;
	}
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public Movie getMovie() {
		return movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public LocalDateTime getBookingTime() {
		return bookingTime;
	}
	public String getStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", movie=" + movie + ", theater=" + theater + ", numberOfSeats=" + numberOfSeats
				+ ", bookingTime=" + bookingTime + ", status=" + status + "]";
	}
 
}
