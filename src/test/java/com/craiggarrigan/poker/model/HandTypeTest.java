package com.craiggarrigan.poker.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HandTypeTest {

	@Test
	public void shouldOrderHighCardHandType() {
		assertEquals(0, HandType.HIGH_CARD.compareTo(HandType.HIGH_CARD));
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.ONE_PAIR) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.TWO_PAIR) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.THREE_OF_A_KIND) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.STRAIGHT) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.FLUSH) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.FULL_HOUSE) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.HIGH_CARD.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}

	@Test
	public void shouldOrderOnePairHandType() {
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.HIGH_CARD) > 0);
		assertEquals(0, HandType.ONE_PAIR.compareTo(HandType.ONE_PAIR));
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.TWO_PAIR) < 0);
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.THREE_OF_A_KIND) < 0);
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.STRAIGHT) < 0);
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.FLUSH) < 0);
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.FULL_HOUSE) < 0);
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.ONE_PAIR.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}

	@Test
	public void shouldOrderTwoPairHandType() {
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.ONE_PAIR) > 0);
		assertEquals(0, HandType.TWO_PAIR.compareTo(HandType.TWO_PAIR));
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.THREE_OF_A_KIND) < 0);
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.STRAIGHT) < 0);
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.FLUSH) < 0);
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.FULL_HOUSE) < 0);
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.TWO_PAIR.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}

	@Test
	public void shouldOrderThreeOfAKindHandType() {
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.ONE_PAIR) > 0);
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.TWO_PAIR) > 0);
		assertEquals(0,
				HandType.THREE_OF_A_KIND.compareTo(HandType.THREE_OF_A_KIND));
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.STRAIGHT) < 0);
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.FLUSH) < 0);
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.FULL_HOUSE) < 0);
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.THREE_OF_A_KIND.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}

	@Test
	public void shouldOrderStraightHandType() {
		assertTrue(HandType.STRAIGHT.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.STRAIGHT.compareTo(HandType.ONE_PAIR) > 0);
		assertTrue(HandType.STRAIGHT.compareTo(HandType.TWO_PAIR) > 0);
		assertTrue(HandType.STRAIGHT.compareTo(HandType.THREE_OF_A_KIND) > 0);
		assertEquals(0, HandType.STRAIGHT.compareTo(HandType.STRAIGHT));
		assertTrue(HandType.STRAIGHT.compareTo(HandType.FLUSH) < 0);
		assertTrue(HandType.STRAIGHT.compareTo(HandType.FULL_HOUSE) < 0);
		assertTrue(HandType.STRAIGHT.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.STRAIGHT.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}
	
	@Test
	public void shouldOrderFlushHandType() {
		assertTrue(HandType.FLUSH.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.FLUSH.compareTo(HandType.ONE_PAIR) > 0);
		assertTrue(HandType.FLUSH.compareTo(HandType.TWO_PAIR) > 0);
		assertTrue(HandType.FLUSH.compareTo(HandType.THREE_OF_A_KIND) > 0);
		assertTrue(HandType.FLUSH.compareTo(HandType.STRAIGHT) > 0);
		assertEquals(0, HandType.FLUSH.compareTo(HandType.FLUSH));
		assertTrue(HandType.FLUSH.compareTo(HandType.FULL_HOUSE) < 0);
		assertTrue(HandType.FLUSH.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.FLUSH.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}
	
	@Test
	public void shouldOrderFullHouseHandType() {
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.ONE_PAIR) > 0);
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.TWO_PAIR) > 0);
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.THREE_OF_A_KIND) > 0);
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.STRAIGHT) > 0);
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.FLUSH) > 0);
		assertEquals(0, HandType.FULL_HOUSE.compareTo(HandType.FULL_HOUSE));
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.QUADS) < 0);
		assertTrue(HandType.FULL_HOUSE.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}
	
	@Test
	public void shouldOrderQuadsHandType() {
		assertTrue(HandType.QUADS.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.QUADS.compareTo(HandType.ONE_PAIR) > 0);
		assertTrue(HandType.QUADS.compareTo(HandType.TWO_PAIR) > 0);
		assertTrue(HandType.QUADS.compareTo(HandType.THREE_OF_A_KIND) > 0);
		assertTrue(HandType.QUADS.compareTo(HandType.STRAIGHT) > 0);
		assertTrue(HandType.QUADS.compareTo(HandType.FLUSH) > 0);
		assertTrue(HandType.QUADS.compareTo(HandType.FULL_HOUSE) > 0);
		assertEquals(0, HandType.QUADS.compareTo(HandType.QUADS));
		assertTrue(HandType.QUADS.compareTo(HandType.STRAIGHT_FLUSH) < 0);
	}
	
	@Test
	public void shouldOrderStraightFlushHandType() {
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.HIGH_CARD) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.ONE_PAIR) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.TWO_PAIR) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.THREE_OF_A_KIND) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.STRAIGHT) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.FLUSH) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.FULL_HOUSE) > 0);
		assertTrue(HandType.STRAIGHT_FLUSH.compareTo(HandType.QUADS) > 0);
		assertEquals(0, HandType.STRAIGHT_FLUSH.compareTo(HandType.STRAIGHT_FLUSH));
	}

}
