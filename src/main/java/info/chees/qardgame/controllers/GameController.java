package info.chees.qardgame.controllers;

import info.chees.qardgame.domain.Game;
import info.chees.qardgame.viewmodels.DisplayState;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {
	
	@RequestMapping("/game/create")
	public String create() {
		long id = 1;
		return "redirect:/game/"+id+"/display";
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
