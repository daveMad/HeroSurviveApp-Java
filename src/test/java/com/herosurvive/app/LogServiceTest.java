package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;
import com.herosurvice.models.*;
import com.herosurvive.service.*;
public class LogServiceTest {

	@Test
	public void shouldInit() {
		Hero hero = new Hero(10, 10, 10);
		Enemy enemy = new Enemy(20, 20, 20, "Bug");
		LogService.getInstance().logBattleDefeat(hero, enemy);
	}

}
