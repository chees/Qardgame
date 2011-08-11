package info.chees.qardgame.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Serialized;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	@Serialized
	private String name;
	
	@Serialized
	private List<Card> hand;
	
	public Player() {}
	
	public Player(String name) {
		id = "1"; // TODO generate UUID
		this.name = name;
		hand = new ArrayList<Card>();
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public List<Card> getHand() {
		return hand;
	}
}
