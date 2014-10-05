package com.craiggarrigan.poker.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	private Suit[] suits = Suit.values();
	private String[] suitsAsStrings = { "C", "D", "H", "S" };
	private Rank[] ranks = Rank.values();
	private String[] ranksAsStrings = { "A", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "J", "Q", "K" };

	@Test(expected = NullPointerException.class)
	public void shouldThrowNPEIfRankNull() {
		new Card(null, Suit.SPADES);
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNPEIfSuitNull() {
		new Card(Rank.ACE, null);
	}

	@Test
	public void shouldConstructCard() {
		Card card = new Card(Rank.ACE, Suit.SPADES);
		assertEquals(Rank.ACE, card.getRank());
		assertEquals(Suit.SPADES, card.getSuit());
	}

	@Test
	public void shouldReturnFriendlyToString() {
		for(int r = 0; r < ranks.length; r++){
			for(int s = 0; s < suits.length; s++){
				Card card = new Card(ranks[r], suits[s]);
				assertEquals(ranksAsStrings[r] + suitsAsStrings[s], card.toString());
			}
		}
	}

}
