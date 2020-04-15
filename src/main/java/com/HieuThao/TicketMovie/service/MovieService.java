package com.HieuThao.TicketMovie.service;

import java.util.List;
import java.util.Optional;

import com.HieuThao.TicketMovie.model.Movie;

public interface MovieService {

	List<Movie> findAllMovie();
	
	Optional<Movie> findById(int id);
	
	void save (Movie movie);
	
	void remove(Movie movie);
}
