package com.herosurvive.service;

import com.herosurvice.models.*;
import com.herosurvive.app.App;

public class LogService {
	private static LogService _logger;

	private LogService() {
	}

	public static synchronized LogService getInstance() {
		if (_logger == null)
			_logger = new LogService();

		return _logger;
	}

	public String logBattleWin(Hero hero, Enemy enemy) {
		String message = "Hero defeated " + enemy.name + " with " + hero.hp + " HP remaining";
		App.Log(message);
		return message;
	}

	public String logBattleDefeat(Hero hero, Enemy enemy) {
		String message = enemy.name + " defeated Hero with " + enemy.hp + " HP remaining";
		App.Log(message);
		return message;
	}

	public String logDeath(Hero hero) {
		String message = "Hero is Dead!! Last seen at position " + hero.position + "!!";
		App.Log(message);
		return message;
	}

	public String logWin(Hero hero) {
		String message = "Hero Survived!";
		App.Log(message);
		return message;
	}

	public String logStart(Hero hero) {
		String message = "Hero started journey with " + hero.hp + "HP!";
		App.Log(message);
		return message;	
	}
}
