package com.wongnai.interview.movie;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long id;
	@Column(length = 500)
	private String name;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> actors = new ArrayList<>();

	/**
	 * Required by JPA.
	 */

}
