package com.craiggarrigan.poker.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuitTest {

	@Test
	public void shouldReturnFriendlyToString() {
		assertEquals("C", Suit.CLUBS.toString());
		assertEquals("D", Suit.DIAMONDS.toString());
		assertEquals("H", Suit.HEARTS.toString());
		assertEquals("S", Suit.SPADES.toString());
	}

}
