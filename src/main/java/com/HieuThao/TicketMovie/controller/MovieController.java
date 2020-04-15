package com.HieuThao.TicketMovie.controller;

import java.util.List;
import java.util.Optional;

import org.atmosphere.util.uri.UriComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.HieuThao.TicketMovie.model.Movie;
import com.HieuThao.TicketMovie.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/movies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findAllMovie() {
		List<Movie> listMovie = movieService.findAllMovie();
		if(listMovie.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listMovie,HttpStatus.OK);
	}
	
	@RequestMapping(value="/movies/{id}",method = RequestMethod.GET)
	public ResponseEntity<Movie> findMovieById(@PathVariable("id") int id) {
		Optional<Movie> movie = movieService.findById(id);
		if(!movie.isPresent()) {
			return new ResponseEntity<>(movie.get(),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(movie.get(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/movies",method = RequestMethod.POST)
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie,UriComponentsBuilder buider) {
		movieService.save(movie);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(buider.path("/movies/{id}").buildAndExpand(movie.getMovieId()).toUri());
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
	}

	@RequestMapping(value="/movies/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable("id") int id){
		Optional<Movie> currentMovie = movieService.findById(id);
		if(!currentMovie.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		currentMovie.get().setActor(movie.getActor());
		currentMovie.get().setTypeMovie(movie.getTypeMovie());
		movieService.save(currentMovie.get());
		return new ResponseEntity<>(currentMovie.get(),HttpStatus.OK);
	}
	
	@RequestMapping(value ="/movies/{id}",method = RequestMethod.DELETE )
	public ResponseEntity<Movie> removeMovie(@PathVariable("id") int id) {
		Optional<Movie> movie = movieService.findById(id);
		if(!movie.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		movieService.remove(movie.get());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
