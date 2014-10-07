package com.craiggarrigan.poker.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankTest {
	
	private Rank[] ranks = Rank.values();
	private String[] ranksAsStrings = { "A", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "J", "Q", "K" };

	@Test
	public void shouldReturnFriendlyToString() {
		for(int r = 0; r < ranks.length; r++){
			Rank rank = ranks[r];
			assertEquals(ranksAsStrings[r], rank.toString());
		}
	}

}
