package info.chees.qardgame.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int number;
	private Suit suit;
	
	// TODO handle Jokers
	
	public Card() {}
	
	public Card(int number, Suit suit) {
		this.number = number;
		this.suit = suit;
	}
	
	public enum Suit {
		DIAMONDS, HEARTS, SPADES, CLUBS
	}

	public static List<Card> createDeck() {
		// TODO create jokers
		List<Card> deck = new ArrayList<Card>();
		for(Suit s : Suit.values()) {
			for(int i = 1; i <= 13; i++) {
				deck.add(new Card(i, s));
			}
		}
		Collections.shuffle(deck);
		return deck;
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
	
	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (!(that instanceof Card))
			return false;
		Card card = (Card) that;
		if (card.suit == suit && card.number == number)
			return true;
		return false;
	}
}
