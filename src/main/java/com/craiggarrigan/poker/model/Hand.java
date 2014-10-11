package com.craiggarrigan.poker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Hand {

	private Card[] cards;

	public Hand(Card[] cards) {
		this.cards = Objects.requireNonNull(cards);
		if (cards.length != 5)
			throw new IllegalArgumentException("A Hand must have 5 cards");
		if (containsDuplicates(cards))
			throw new IllegalArgumentException(
					"A Hand must not contain duplicate cards");
	}

	public HandType getType() {
		if(hasStraight() && hasFlush())
			return HandType.STRAIGHT_FLUSH;
		else if (hasQuads())
			return HandType.QUADS;
		else if(hasFullHouse())
			return HandType.FULL_HOUSE;
		else if (hasFlush())
			return HandType.FLUSH;
		else if (hasStraight())
			return HandType.STRAIGHT;
		else if (hasThreeOfAKind())
			return HandType.THREE_OF_A_KIND;
		else if (hasTwoPair())
			return HandType.TWO_PAIR;
		else if (hasPair())
			return HandType.ONE_PAIR;
		else
			return HandType.HIGH_CARD;
	}

	private boolean hasQuads() {
		return getRankDistribution().size() == 2 && getRankDistribution().values().containsAll(Arrays.asList(1,4));
	}
	
	private boolean hasFullHouse() {
		return getRankDistribution().size() == 2 && getRankDistribution().values().containsAll(Arrays.asList(2,3));
	}

	private boolean hasFlush() {
		Set<Suit> suitSet = new HashSet<Suit>(cards.length);
		for (Card c : cards)
			suitSet.add(c.getSuit());
		return suitSet.size() == 1;
	}

	private boolean hasStraight() {
		return hasConventionalStraight() || hasRoyalStraight();
	}

	private boolean hasConventionalStraight() {
		// There are 5 distinct ranks and the difference between the declared
		// order of the first and last rank is 4
		SortedSet<Rank> sortedRankSet = new TreeSet<Rank>(getRankSet());
		return sortedRankSet.size() == 5
				&& sortedRankSet.last().ordinal()
						- sortedRankSet.first().ordinal() == 4;
	}

	private boolean hasRoyalStraight() {
		return getRankSet().containsAll(
				Arrays.asList(Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING,
						Rank.ACE));
	}

	private boolean hasThreeOfAKind() {
		return getRankDistribution().size() == 3 && getRankDistribution().values().contains(3);
	}

	private boolean hasTwoPair() {
		// Two distict ranks for the two pairs, plus an extra
		return getRankSet().size() == 3;
	}

	private boolean hasPair() {
		// One rank for the pair and 3 for the remaining cards
		return getRankSet().size() == 4;
	}
	
	/**
	 * Returns a mapping from the rank of a card to the number of cards in the hand which have that rank.
	 * @return the rank distribution map
	 */
	private Map<Rank, Integer> getRankDistribution() {
		Map<Rank, Integer> map = new HashMap<Rank, Integer>();
		for(Rank rank : getRankSet()){
			map.put(rank, Collections.frequency(getRankList(), rank));
		}
		return map;
	}
	
	/**
	 * Returns the ranks of the cards in the hand. 
	 * @return the ranks of the cards in the hand
	 */
	private List<Rank> getRankList() {
		List<Rank> rankList = new ArrayList<Rank>(cards.length);
		for (Card card : cards)
			rankList.add(card.getRank());
		return rankList;
	}

	/**
	 * Returns the set of distinct ranks of cards in the hand.
	 * @return the set of distinct ranks
	 */
	private Set<Rank> getRankSet() {
		Set<Rank> rankSet = new HashSet<Rank>(cards.length);
		for (Card card : cards)
			rankSet.add(card.getRank());
		return rankSet;
	}

	private static boolean containsDuplicates(Card[] cards) {
		Set<Card> set = new HashSet<Card>(cards.length);
		set.addAll(Arrays.asList(cards));
		return set.size() != cards.length;
	}

}
