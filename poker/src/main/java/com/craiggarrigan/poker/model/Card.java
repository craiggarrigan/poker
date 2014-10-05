package com.craiggarrigan.poker.model;

import java.util.Objects;

public class Card {
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = Objects.requireNonNull(rank);
		this.suit = Objects.requireNonNull(suit);
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return rank.toString() + suit.toString();
	}

}
