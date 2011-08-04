package info.chees.qardgame.controllers;

import info.chees.qardgame.domain.Game;
import info.chees.qardgame.viewmodels.DisplayState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

@Controller
public class GameController {
	
	@Autowired private ObjectifyFactory objectifyFactory;
	
	@RequestMapping("/game/create")
	public String create() {
		
		Game game = new Game();
		
		Objectify ofy = objectifyFactory.begin();
		ofy.put(game);
		
		return "redirect:/game/"+game.getId()+"/display";
	}
	
	@RequestMapping("/game/{gameId}/display")
	public String display(@PathVariable Long gameId, Model model) {
		model.addAttribute("gameId", gameId);
		return "display";
	}
	
	@RequestMapping("game/{gameId}/displaystate")
	public @ResponseBody DisplayState displayState(@PathVariable Long gameId, Model model) {
		
		Game game = new Game(); // TODO get the game with Objectify
		
		DisplayState displayState = new DisplayState(game);
		return displayState;
	}
}
