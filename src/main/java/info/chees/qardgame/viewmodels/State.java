package info.chees.qardgame.viewmodels;

import info.chees.qardgame.domain.Card;
import info.chees.qardgame.domain.Game;
import info.chees.qardgame.domain.Player;

import java.util.List;

public class State {
	private boolean started;
	
	private boolean yourTurn;
	
	private List<Card> cards;

	public State() {}
	
	public State(Game game, String userId) {
		started = game.isStarted();
		
		Player player = game.getPlayerById(userId);
		
		Player currentPlayer = game.getPlayers().get(game.getCurrentPlayer());
		if(currentPlayer == player)
			yourTurn = true;
		else
			yourTurn = false;
		
		cards = player.getHand();
	}
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isYourTurn() {
		return yourTurn;
	}

	public void setYourTurn(boolean yourTurn) {
		this.yourTurn = yourTurn;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
