package com.craiggarrigan.poker.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test(expected = NullPointerException.class)
	public void shouldThrowNPEIfCardArrayNull() {
		new Hand(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIAEIfCardArrayLessThanLength5() {
		new Hand(new Card[] { new Card(Rank.ACE, Suit.CLUBS),
				new Card(Rank.TWO, Suit.CLUBS),
				new Card(Rank.THREE, Suit.CLUBS),
				new Card(Rank.FOUR, Suit.CLUBS) });
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIAEIfCardArrayGreaterThanLength5() {
		new Hand(
				new Card[] { new Card(Rank.ACE, Suit.CLUBS),
						new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.THREE, Suit.CLUBS),
						new Card(Rank.FOUR, Suit.CLUBS),
						new Card(Rank.FIVE, Suit.CLUBS),
						new Card(Rank.SIX, Suit.CLUBS) });
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIAEIfCardArrayContainsDuplicates() {
		new Hand(
				new Card[] { new Card(Rank.ACE, Suit.CLUBS),
						new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.THREE, Suit.CLUBS),
						new Card(Rank.ACE, Suit.CLUBS),
						new Card(Rank.FIVE, Suit.CLUBS) });
	}
	
	@Test
	public void shouldDetermineHighCardHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.FOUR, Suit.DIAMONDS),
						new Card(Rank.SIX, Suit.HEARTS),
						new Card(Rank.SEVEN, Suit.HEARTS),
						new Card(Rank.JACK, Suit.SPADES) });
		
		assertEquals(HandType.HIGH_CARD, hand.getType());
	}
	
	@Test
	public void shouldDetermineOnePairHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.TWO, Suit.DIAMONDS),
						new Card(Rank.SIX, Suit.HEARTS),
						new Card(Rank.SEVEN, Suit.HEARTS),
						new Card(Rank.JACK, Suit.SPADES) });
		
		assertEquals(HandType.ONE_PAIR, hand.getType());
	}
	
	@Test
	public void shouldDetermineTwoPairHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.TWO, Suit.DIAMONDS),
						new Card(Rank.SIX, Suit.HEARTS),
						new Card(Rank.SIX, Suit.CLUBS),
						new Card(Rank.JACK, Suit.SPADES) });
		
		assertEquals(HandType.TWO_PAIR, hand.getType());
	}
	
	@Test
	public void shouldDetermineThreeOfAKindHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.TWO, Suit.DIAMONDS),
						new Card(Rank.TWO, Suit.HEARTS),
						new Card(Rank.SEVEN, Suit.HEARTS),
						new Card(Rank.JACK, Suit.SPADES) });
		
		assertEquals(HandType.THREE_OF_A_KIND, hand.getType());
	}
	
	@Test
	public void shouldDetermineStraightHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.ACE, Suit.SPADES),
						new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.THREE, Suit.DIAMONDS),
						new Card(Rank.FOUR, Suit.HEARTS),
						new Card(Rank.FIVE, Suit.HEARTS) });
		
		assertEquals(HandType.STRAIGHT, hand.getType());
	}
	
	@Test
	public void shouldDetermineFlushHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.HEARTS),
						new Card(Rank.FOUR, Suit.HEARTS),
						new Card(Rank.SIX, Suit.HEARTS),
						new Card(Rank.SEVEN, Suit.HEARTS),
						new Card(Rank.JACK, Suit.HEARTS) });
		
		assertEquals(HandType.FLUSH, hand.getType());
	}
	
	@Test
	public void shouldDetermineFullHouseHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.TWO, Suit.DIAMONDS),
						new Card(Rank.TWO, Suit.HEARTS),
						new Card(Rank.SEVEN, Suit.HEARTS),
						new Card(Rank.SEVEN, Suit.SPADES) });
		
		assertEquals(HandType.FULL_HOUSE, hand.getType());
	}
	
	@Test
	public void shouldDetermineQuadsHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TWO, Suit.CLUBS),
						new Card(Rank.NINE, Suit.DIAMONDS),
						new Card(Rank.NINE, Suit.HEARTS),
						new Card(Rank.NINE, Suit.CLUBS),
						new Card(Rank.NINE, Suit.SPADES) });
		
		assertEquals(HandType.QUADS, hand.getType());
	}
	
	@Test
	public void shouldDetermineStraightFlushHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.FOUR, Suit.DIAMONDS),
						new Card(Rank.FIVE, Suit.DIAMONDS),
						new Card(Rank.SIX, Suit.DIAMONDS),
						new Card(Rank.SEVEN, Suit.DIAMONDS),
						new Card(Rank.EIGHT, Suit.DIAMONDS) });
		
		assertEquals(HandType.STRAIGHT_FLUSH, hand.getType());
	}
	
	@Test
	public void shouldDetermineRoyalFlushAsStraightFlushHand(){
		Hand hand = new Hand(
				new Card[] { new Card(Rank.TEN, Suit.DIAMONDS),
						new Card(Rank.JACK, Suit.DIAMONDS),
						new Card(Rank.QUEEN, Suit.DIAMONDS),
						new Card(Rank.KING, Suit.DIAMONDS),
						new Card(Rank.ACE, Suit.DIAMONDS) });
		
		assertEquals(HandType.STRAIGHT_FLUSH, hand.getType());
	}

}
