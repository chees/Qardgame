package info.chees.qardgame.controllers;

import info.chees.qardgame.domain.Game;
import info.chees.qardgame.domain.Player;
import info.chees.qardgame.viewmodels.DisplayState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

@Controller
public class GameController {
	
	@Autowired private ObjectifyFactory ofyFactory;
	
	@RequestMapping("/game/create")
	public String create() {
		
		Game game = new Game();
		
		Objectify ofy = ofyFactory.begin();
		ofy.put(game);
		
		return "redirect:/game/"+game.getId()+"/display";
	}
	
	@RequestMapping("/game/{gameId}/display")
	public String display(@PathVariable Long gameId, Model model) {
		model.addAttribute("gameId", gameId);
		return "display";
	}
	
	@RequestMapping("/game/{gameId}/displaystate")
	public @ResponseBody DisplayState displayState(@PathVariable Long gameId, Model model) {
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		DisplayState displayState = new DisplayState(game);
		return displayState;
	}
	
	@RequestMapping(value = "/game/{gameId}/join", method = RequestMethod.GET)
	public String join(@PathVariable Long gameId, Model model) {
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		if(game.isStarted()) {
			// TODO show a message
			return "redirect:/";
		}
		
		model.addAttribute("gameId", gameId);
		
		return "join";
	}
	
	@RequestMapping(value = "/game/{gameId}/join", method = RequestMethod.POST)
	public String joinPost(@PathVariable Long gameId, @RequestParam("name") String name, Model model) {
		
		// TODO do in a transaction?
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		if(game.isStarted()) {
			// TODO show a message
			return "redirect:/";
		}
		
		game.getPlayers().add(new Player(name));
		
		ofy.put(Game.class, game);
		System.out.println("Number of players: "+game.getPlayers().size());
		
		return "redirect:/game/"+gameId+"/play";
	}
}
