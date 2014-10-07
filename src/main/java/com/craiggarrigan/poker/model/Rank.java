package com.craiggarrigan.poker.model;

public enum Rank {
	ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT(
			"8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");

	private String toStringValue;

	Rank(String toStringValue) {
		this.toStringValue = toStringValue;
	}

	@Override
	public String toString() {
		return toStringValue;
	}
}
