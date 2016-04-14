package com.prabhat.movie.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prabhat.movie.dao.Movie_DAO;
import com.prabhat.movie.domain.Artist;
import com.prabhat.movie.domain.Director;
import com.prabhat.movie.domain.Genere;
import com.prabhat.movie.domain.Movie;
import com.prabhat.movie.domain.Rating;

@Controller
public class MovieController {
	@Resource
	private Movie_DAO movie_dao;
//	private SessionFactory sessionFactory;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHomePage(Model model) {
		List<Movie> mov =movie_dao.getAllMovie();
/*		for(Movie movi:mov)
		{
			System.out.println(movi.getTitle());
		}
*/		 model.addAttribute("movies", movie_dao.getAllMovie());
		return "movie";
	}

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/movie/add", method = RequestMethod.GET)
	public String add(Model model) {
		Movie movie = new Movie();
		Artist at=new Artist();
		Director dt=new Director();
		model.addAttribute("movieform", movie);
		return "addMovie";
	}

	@RequestMapping(value = "/movie/add", method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute("movieform") Movie movie, BindingResult result) throws Exception {// ,
		movie_dao.addMovie(movie);
		return "redirect:/home";
	}

	
	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable int id) throws Exception {
//		movie_dao.deleteMovie(movieid);
//		System.out.println(id);
//		System.out.println("I am here Shree");
		movie_dao.deleteMovie(movie_dao.retriveMovie(id));
		return "redirect:/home";
	}
	@RequestMapping(value = "/movie/search", method = RequestMethod.POST)
	public String search(Model model, @PathVariable int id) throws Exception {
//		movie_dao.deleteMovie(movieid);
//		System.out.println(id);
//		System.out.println("I am here Shree");
		movie_dao.deleteMovie(movie_dao.retriveMovie(id));
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/movie/edit/{id}", method = RequestMethod.GET)
	public String editMovie(Model model, @PathVariable int id) throws Exception {
        Movie mov= movie_dao.retriveMovie(id);
        model.addAttribute("movieform",mov);
		return "addMovie";
	}
	
	@RequestMapping(value = "/movie/edit/{id}", method = RequestMethod.POST)
	public String saveEditMovie(Movie movie, @PathVariable int id, BindingResult result) throws Exception {
   System.out.println(" i am here");
   movie.setId(id);
   movie_dao.modifyMovie(movie);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/movie/update", method = RequestMethod.GET)
	public String view(Model model) {
		return "updateMovie";
	}

	@ModelAttribute("rating")
	public Rating[] getRating() {
		return Rating.values();
	}

	@ModelAttribute("genere")
	public Genere[] getGenere() {
		return Genere.values();
	}

}
