package com.wongnai.interview.movie.search;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.wongnai.interview.movie.external.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MovieDataService;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {
	@Autowired
	private MovieDataService movieDataService;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 2 => Implement this method by using data from MovieDataService
		// All test in SimpleMovieSearchServiceIntegrationTest must pass.
		// Please do not change @Component annotation on this class
		// Fetch all movies
		// Fetch all movies
		List<MovieData> allMovies = movieDataService.fetchAll();

		String pattern = "\\b" + Pattern.quote(queryText.toLowerCase()) + "\\b";

        return allMovies.stream()
				.filter(movieData -> movieData.getTitle().toLowerCase().matches(".*" + pattern + ".*")
						&& !movieData.getTitle().equalsIgnoreCase(queryText))
				.map(movieData -> {
					Movie movie = new Movie();
					movie.setName(movieData.getTitle());
					movie.setActors(movieData.getCast());
					return movie;
				})
				.collect(Collectors.toList());
	}
}
