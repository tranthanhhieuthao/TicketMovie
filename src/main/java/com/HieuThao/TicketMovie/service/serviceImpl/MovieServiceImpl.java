package com.HieuThao.TicketMovie.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HieuThao.TicketMovie.model.Movie;
import com.HieuThao.TicketMovie.repository.MovieRepository;
import com.HieuThao.TicketMovie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> findAllMovie() {
		return (List<Movie>) movieRepository.findAll();
	}

	@Override
	public Optional<Movie> findById(int id) {
		return movieRepository.findById(id);
	}

	@Override
	public void save(Movie movie) {
		movieRepository.save(movie);
		
	}

	@Override
	public void remove(Movie movie) {
		movieRepository.delete(movie);
		
	}

}
