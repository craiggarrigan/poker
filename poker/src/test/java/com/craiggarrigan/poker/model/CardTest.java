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
	
	@Test
	public void shouldOverrideEquals(){
		Card aceSpades1 = new Card(Rank.ACE, Suit.SPADES);
		Card aceSpades2 = new Card(Rank.ACE, Suit.SPADES);
		Card sevenHearts = new Card(Rank.SEVEN, Suit.HEARTS);
		// It is reflexive: for any non-null reference value x, x.equals(x) should return true.
		assertTrue(aceSpades1.equals(aceSpades1));
		// It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
		assertTrue(aceSpades1.equals(aceSpades2));
		assertTrue(aceSpades2.equals(aceSpades1));
		assertFalse(aceSpades1.equals(sevenHearts));
		assertFalse(sevenHearts.equals(aceSpades1));
		// For any non-null reference value x, x.equals(null) should return false.
		assertFalse(aceSpades1.equals(null));
	}
	
	@Test
	public void shouldObeyHashCodeContract(){
		Card aceSpades1 = new Card(Rank.ACE, Suit.SPADES);
		Card aceSpades2 = new Card(Rank.ACE, Suit.SPADES);		
		// Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. 
		int hashCode = aceSpades1.hashCode();
		assertEquals(hashCode, aceSpades1.hashCode());
		// If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
		assertEquals(aceSpades1.hashCode(), aceSpades2.hashCode());
	}

}
