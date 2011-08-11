package info.chees.qardgame.viewmodels;

import info.chees.qardgame.domain.Card;
import info.chees.qardgame.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class State {
	private boolean started;
	
	private boolean yourTurn;
	
	private List<Card> cards;

	public State() {}
	
	public State(Game game) {
		started = game.isStarted();
		yourTurn = false; // TODO
		cards = new ArrayList<Card>(); // TODO
		cards.add(new Card(3, Card.Suit.CLUBS));
		cards.add(new Card(11, Card.Suit.DIAMONDS));
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
