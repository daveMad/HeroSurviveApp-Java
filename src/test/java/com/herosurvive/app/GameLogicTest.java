package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.herosurvice.models.Enemy;
import com.herosurvice.models.Hero;

import junit.framework.Assert;

public class GameLogicTest {

	@Test
	public void logResultShouldBeOk() {
		Hero hero = new Hero(12, 100, 10);
		GameLogic logic = new GameLogic(hero);
		String expected = "Survived";
		logic.logResult();
	}
	
	@Test
	public void shouldNotStartIfMapIsNull(){
		GameLogic logic = new GameLogic(new Hero(12, 100, 10));
		logic.start(); 
		assertNull("", logic.finished);
	}
	
	@Test
	public void shouldStartBattleAndReturnResult(){
		GameLogic logic = new GameLogic(new Hero(12, 100, 10));
		assertEquals(true, logic.startBattle(new Enemy(12,50,10)));
	}

}
