package info.chees.qardgame.domain;

public class Card {
	private int number;
	private Suit suit;
	
	public enum Suit {
		DIAMONDS, HEARTS, SPADES, CLUBS
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}
}
