package com.herosurvive.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.herosurvice.models.Enemy;
import com.herosurvice.models.Hero;
import com.herosurvive.service.GameMap;

public class GameMapTest {

	@Test
	public void shouldInit() {
		Hero hero = new Hero(10, 100, 40);
		int mapEndPosition = 25;

		GameMap map = new GameMap(hero, getSampleEnemies(), mapEndPosition);
		assertNotNull(map);
	}

	public ArrayList<Enemy> getSampleEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy(5, 10, 10));
		enemies.add(new Enemy(12, 10, 10));
		enemies.add(new Enemy(50, 10, 10));
		return enemies;

	}
	
	@Test 
	public void shouldArriveEndPoint(){
		Hero hero = new Hero(10, 100, 40);
		int mapEndPosition = 25;

		GameMap map = new GameMap(hero, getSampleEnemies(), mapEndPosition);
		hero.moveRange(15);
		assertTrue(map.heroAtEndPoint());
	}

}
