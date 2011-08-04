package info.chees.qardgame.domain;

import java.util.List;

public class Game {
	private Long id;
	
	private List<Player> players;
	
	private boolean started;
	
	private int currentPlayer;
	
	private List<Card> openCards;
	
	private List<Card> closedCards;
	
	////
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public List<Card> getOpenCards() {
		return openCards;
	}

	public void setOpenCards(List<Card> openCards) {
		this.openCards = openCards;
	}

	public List<Card> getClosedCards() {
		return closedCards;
	}

	public void setClosedCards(List<Card> closedCards) {
		this.closedCards = closedCards;
	}
	
}
