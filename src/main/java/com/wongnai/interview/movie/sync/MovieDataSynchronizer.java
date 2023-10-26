package com.wongnai.interview.movie.sync;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.external.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.MovieRepository;
import com.wongnai.interview.movie.external.MovieDataService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieDataSynchronizer {
	@Autowired
	private MovieDataService movieDataService;

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public void forceSync() {
		//TODO: implement this to sync movie into repository
		// Fetch all movies from the external service
		// Clear existing data
		movieRepository.deleteAll();
		List<MovieData> allMovies = movieDataService.fetchAll();
		List<Movie> movies = allMovies.stream().map(movieData -> {
			Movie movie = new Movie();
			movie.setName(movieData.getTitle());
			movie.setActors(movieData.getCast());
			return movie;
		}).collect(Collectors.toList());
		movieRepository.saveAll(movies);
	}
	@PostConstruct
	public void init() {
		forceSync();
	}
}
