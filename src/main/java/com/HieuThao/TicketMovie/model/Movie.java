package com.HieuThao.TicketMovie.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="movie")
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	
	@Column(name="movie_code")
	private String movieCode;
	
	@Column(name="name_movie")
	private String nameMovie;
	
	@Column(name="actor")
	private String actor;
	
	@Column(name="type_movie")
	private String typeMovie;
	
	@Column(name="date_watch")
	private String DateWatch;
	
	@Column(name="time_watch")
	private String timeWatch;
	
	@Column(name="date_start")
	private Date dateStart;
}
