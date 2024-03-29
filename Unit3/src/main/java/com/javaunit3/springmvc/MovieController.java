package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class MovieController {

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping("/bestMovie")
	public String getBestMoviePage(Model model) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();
		movieEntityList.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));
		
		if(movieEntityList.size() != 0) {
			MovieEntity movieWithMostVotes = movieEntityList.get(movieEntityList.size() - 1);
			List<String> voterNames = new ArrayList<>();
			for (VoteEntity vote : movieWithMostVotes.getVotes()) {
				voterNames.add(vote.getVoterName());
			}

			String voterNamesList = String.join(",", voterNames);
			if (movieWithMostVotes.getTitle() != null) {
				model.addAttribute("bestMovie", movieWithMostVotes.getTitle());
			}else {
				model.addAttribute("bestMovie", "No Title");
			}
			if(voterNamesList != null) {
				model.addAttribute("bestMovieVoters", voterNamesList);
			}else {
				model.addAttribute("bestMovieVoters", "Empty");
			}
		}
		
		session.getTransaction().commit();

		return "bestMovie";
	}

	@RequestMapping("/voteForBestMovieForm")
	public String voteForBestMovieFormPage(Model model) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();

		session.getTransaction().commit();

		model.addAttribute("movies", movieEntityList);

		return "voteForBestMovie";
	}

	@RequestMapping("/voteForBestMovie")
	public String voteForBestMovie(HttpServletRequest request, Model model) {
		String movieId = request.getParameter("movieId");
		String voterName = request.getParameter("voterName");

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		MovieEntity movieEntity = (MovieEntity) session.get(MovieEntity.class, Integer.parseInt(movieId));
		VoteEntity newVote = new VoteEntity();
		newVote.setVoterName(voterName);
		movieEntity.addVote(newVote);

		session.update(movieEntity);

		session.getTransaction().commit();

		return "voteForBestMovie";
	}

	@RequestMapping("/addMovieForm")
	public String addMovieForm() {
		return "addMovie";
	}

	@RequestMapping("/addMovie")
	public String addMovie(HttpServletRequest request) {
		String movieTitle = request.getParameter("movieTitle");
		String maturityRating = request.getParameter("maturityRating");
		String genre = request.getParameter("genre");

		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setTitle(movieTitle);
		movieEntity.setMaturityRating(maturityRating);
		movieEntity.setGenre(genre);

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(movieEntity);

		session.getTransaction().commit();

		return "addMovie";
	}

}
