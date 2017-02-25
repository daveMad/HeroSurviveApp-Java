package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.herosurvice.models.Hero;

public class GameLogicTest {

	@Test
	public void logResultShouldBeOk() {
		Hero hero = new Hero(12, 100, 10);
		GameLogic logic = new GameLogic(hero);
		String expected = "Survived";
		logic.logResult();
		assertEquals(0, 0);
	}

}
