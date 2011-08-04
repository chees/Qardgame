package info.chees.qardgame.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Serialized;
import com.googlecode.objectify.annotation.Unindexed;

@Entity
@Unindexed
public class Game {
	
	@Id
	private Long id;
	
	private List<Player> players;
	
	@Indexed
	private boolean started;
	
	private int currentPlayer;
	
	@Serialized
	private List<Card> openCards;
	
	@Serialized
	private List<Card> closedCards;
	
	public Game() {
		players = new ArrayList<Player>();
		started = false;
		openCards = new ArrayList<Card>();
		closedCards = Card.createDeck();
	}
	
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
