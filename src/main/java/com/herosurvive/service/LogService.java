package com.herosurvive.service;

import com.herosurvice.models.*;
import com.herosurvive.app.App;

public class LogService {
	private static LogService _logger;
	private LogService(){
	}
	
	public static synchronized LogService getInstance(){
		if(_logger == null)
			_logger = new LogService();
		
		return _logger;
	}
	
	public String logBattleWin(Hero hero,Enemy enemy){
		String message = "Hero defeated "+enemy.name+" with "+hero.hp+" HP remaining";
		App.Log(message);
		return message;
	}
	
	public String logBattleDefeat(Hero hero,Enemy enemy){
		String message = enemy.name + " defeated Hero with "+enemy.hp+" HP remaining";
		App.Log(message);
		return message;
	}
}
