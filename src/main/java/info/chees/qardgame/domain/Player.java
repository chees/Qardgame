package info.chees.qardgame.domain;

import java.util.List;

public class Player {
	private Long id;
	
	private String name;
	
	List<Card> hand;

	////
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
