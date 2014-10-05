package com.craiggarrigan.poker.model;

public enum Suit {

	CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

	private String toStringValue;

	Suit(String toStringValue) {
		this.toStringValue = toStringValue;
	}
	
	@Override
	public String toString() {
		return toStringValue;
	}

}
