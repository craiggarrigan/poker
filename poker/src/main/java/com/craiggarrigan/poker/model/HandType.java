package com.craiggarrigan.poker.model;
// TODO Remove ROYAL_FLUSH - it is just a STRAIGHT_FLUSH which wins via the high-card tie-breaker
public enum HandType {
	HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, QUADS, STRAIGHT_FLUSH, ROYAL_FLUSH
}
