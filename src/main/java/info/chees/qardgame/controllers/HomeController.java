package info.chees.qardgame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		
		// TODO get list of games
		
		return "home";
	}
}
