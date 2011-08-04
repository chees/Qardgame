package info.chees.qardgame.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	@Test
	public void createDeckShouldHave52Cards() {
		assertEquals(52, Card.createDeck().size());
	}
}
