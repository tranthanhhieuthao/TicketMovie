package com.HieuThao.TicketMovie.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HieuThao.TicketMovie.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
