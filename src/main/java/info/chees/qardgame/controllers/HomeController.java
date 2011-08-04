package info.chees.qardgame.controllers;

import info.chees.qardgame.domain.Game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

@Controller
public class HomeController {
	
	@Autowired private ObjectifyFactory ofyFactory;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		Objectify ofy = ofyFactory.begin();
		List<Game> games = ofy.query(Game.class).list();
		
		model.addAttribute("games", games);
		
		return "home";
	}
}
