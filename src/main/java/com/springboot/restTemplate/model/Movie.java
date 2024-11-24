package com.springboot.restTemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Long id;
	private String title;
    private String genre;
    
    @ManyToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Theater theater;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
}
