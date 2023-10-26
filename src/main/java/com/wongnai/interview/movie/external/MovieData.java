package com.wongnai.interview.movie.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieData {
	private String title;
	private int year;
	private List<String> cast;
	private List<String> genres;

}
