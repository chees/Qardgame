package info.chees.qardgame.controllers;

import info.chees.qardgame.domain.Card;
import info.chees.qardgame.domain.Game;
import info.chees.qardgame.domain.Player;
import info.chees.qardgame.viewmodels.DisplayState;
import info.chees.qardgame.viewmodels.State;

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
	
	// TODO this class should probably be divided into smaller classes
	
	@Autowired private ObjectifyFactory ofyFactory;
	
	@RequestMapping("/game/create")
	public String create() {
		
		Game game = new Game();
		
		Objectify ofy = ofyFactory.begin();
		ofy.put(game);
		
		return "redirect:/game/"+game.getId()+"/display";
	}
	
	@RequestMapping("/game/{gameId}/display")
	public String display() {
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
	public String joinPost(@PathVariable Long gameId, @RequestParam String name, Model model) {
		
		// TODO do in a transaction?
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		if(game.isStarted()) {
			// TODO show a message
			return "redirect:/";
		}
		
		game.getPlayers().add(new Player(name));
		
		ofy.put(game);
		
		return "redirect:/game/"+gameId;
	}
	
	@RequestMapping("/game/{gameId}")
	public String play(@PathVariable Long gameId, Model model) {
		model.addAttribute("gameId", gameId);
		return "play";
	}
	
	@RequestMapping("/game/{gameId}/state")
	public @ResponseBody State state(@PathVariable Long gameId, Model model) {
		
		// TODO get the userId
		String userId = "1";
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		State state = new State(game, userId);
		return state;
	}
	
	@RequestMapping(value = "/game/{gameId}/start", method = RequestMethod.POST)
	public @ResponseBody String start(@PathVariable Long gameId) {
		// TODO do in a transaction
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		game.start();
		
		ofy.put(game);
		
		return "";
	}
	
	@RequestMapping(value = "/game/{gameId}/play", method = RequestMethod.POST)
	public @ResponseBody
	String play(@PathVariable Long gameId, @RequestParam int cardNumber,
			@RequestParam Card.Suit cardSuit, @RequestParam String userId) {
		// TODO transaction?
		
		System.out.println(cardNumber);
		System.out.println(cardSuit);
		
		Objectify ofy = ofyFactory.begin();
		Game game = ofy.get(Game.class, gameId);
		
		Player currentPlayer = game.getPlayers().get(game.getCurrentPlayer());
		// TODO check if currentPlayer.userId == userId
		
		Card card = new Card(cardNumber, cardSuit);
		
		if(!currentPlayer.getHand().remove(card)) {
			throw new RuntimeException("/me mutters something about cheaters");
		}
		
		game.getOpenCards().add(card);
		
		ofy.put(game);
		
		return "";
	}
}
