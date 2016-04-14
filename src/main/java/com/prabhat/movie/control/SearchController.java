package com.prabhat.movie.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prabhat.movie.dao.Movie_DAO;
import com.prabhat.movie.domain.Movie;

@Controller
public class SearchController {
	@Resource
	private Movie_DAO movieDAO;
	
	@RequestMapping(value = {"movie/search"," * "}, method = RequestMethod.GET)
	public String searchMovie(Model model) {
		Movie movie = new Movie();
	
		return "search";
	}
	
	@RequestMapping(value = "movie/search/searchByName", method = RequestMethod.GET)
	public String searchByTitle(@RequestParam("title") String title, Model model) {
		List<Movie> search = movieDAO.searchMovie(title);
		model.addAttribute("movies",search);
		return "movie";
	}

	@RequestMapping(value = "movie/search/searchByYear", method = RequestMethod.GET)
	public String searchByYear(@RequestParam("year") String year, Model model) {
		List<Movie> search = movieDAO.searchMovieByYear(year);
		model.addAttribute("movies",search);
		return "movie";
	}
	
	@RequestMapping(value = "movie/search/searchByArtist", method = RequestMethod.GET)
	public String searchByArtist(@RequestParam("artist") String artist, Model model) {
		List<Movie> searchMovies = movieDAO.searchMovieByArtistName(artist);
		model.addAttribute("movies",searchMovies);
		return "movie";
	}


}
