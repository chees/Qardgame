package info.chees.qardgame.viewmodels;

import info.chees.qardgame.domain.Card;
import info.chees.qardgame.domain.Game;
import info.chees.qardgame.domain.Player;

import java.util.List;

public class DisplayState {

	private boolean started;
	private String[] players;
	private int currentPlayer;
	private Card openCard;
	
	public DisplayState(Game game) {
		setStarted(game.isStarted());
		
		List<Player> gPlayers = game.getPlayers();
		if(gPlayers == null) {
			this.setPlayers(null);
		} else {
			String[] players = new String[gPlayers.size()];
			for(int i = 0; i < gPlayers.size(); i++) {
				players[i] = gPlayers.get(i).getName();
			}
			this.setPlayers(players);
		}
		
		setCurrentPlayer(game.getCurrentPlayer());
		
		if(game.getOpenCards() == null || game.getOpenCards().size() == 0) {
			setOpenCard(null);
		} else {
			setOpenCard(game.getOpenCards().get(game.getOpenCards().size()-1));
		}
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isStarted() {
		return started;
	}

	public void setPlayers(String[] players) {
		this.players = players;
	}

	public String[] getPlayers() {
		return players;
	}

	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public void setOpenCard(Card openCard) {
		this.openCard = openCard;
	}

	public Card getOpenCard() {
		return openCard;
	}
	
}
