package com.herosurvive.service;

import java.util.ArrayList;
import java.util.List;

import com.herosurvice.models.*;
import com.herosurvive.app.App;

public class LogService {
	
	
	private static LogService _logger;

	private List<String> fullOutput;

	private LogService() {
		fullOutput = new ArrayList<String>();
	}

	public static synchronized LogService getInstance() {
		if (_logger == null)
			_logger = new LogService();

		return _logger;
	}

	public void logBattleWin(Hero hero, Enemy enemy) {
		String message = "Hero defeated " + enemy.name + " with " + hero.hp + " HP remaining";
		App.Log(message);
		add(message);
	}

	public void add(String message) {
		fullOutput.add(message);
	}

	public void logBattleDefeat(Hero hero, Enemy enemy) {
		String message = enemy.name + " defeated Hero with " + enemy.hp + " HP remaining";
		App.Log(message);
		add(message);
		
		logDeath(hero); // if here is dead, we can just log it here;
	}

	public void logDeath(Hero hero) {
		String message = "Hero is Dead!! Last seen at position " + hero.position + "!!";
		App.Log(message);
		add(message);
	}

	public void logWin(Hero hero) {
		String message = "Hero Survived!";
		App.Log(message);
		add(message);
	}

	public void logStart(Hero hero) {
		String message = "Hero started journey with " + hero.hp + "HP!";
		App.Log(message);
		add(message);
	}
}
