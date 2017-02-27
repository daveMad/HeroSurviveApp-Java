package com.herosurvive.app;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.text.html.HTMLEditorKit.Parser;

import com.herosurvice.models.*;
import com.herosurvive.service.*;

public class GameLogic {
	Boolean finished; // represented whether the resources are collected
						// or not
	GameMap map;
	Hero hero;
	
	public GameLogic(Hero hero) {
		// to do : initialize game map using FileLogic helper methods,
		// invoke update()
		this.hero = hero;
	}

	public void start() {
		// to do :
		// call update method, set flag
		if (map == null) {
			map = new GameMap(this.hero, ParserLogic.getInstance().parsedData.enemies, ParserLogic.getInstance().parsedData.resourcePoint);
			return;
		}
		LogService.getInstance().logStart(this.hero);
		finished = false;
		update();
		// when execution is here, means that the game is done, and since the
		// logger saves everything, we can print the result here;
		LogService.getInstance().writeResultToFile();
	}

	public void update() {
		while (!finished) {
			// to do : update hero position
			// to do : check if hero intercepts with an instance of ICharacter
			// to do : check if hero at the end point (Resource location point)
			if (map.heroAtEndPoint()) {
				LogService.getInstance().logWin(this.hero);
				logResult();
			}
			Enemy enemy = (Enemy) map.checkInterception();
			if (enemy != null) { // to do : start an attack
				if (!startBattle(enemy)) {
					LogService.getInstance().logBattleDefeat(hero, enemy);
					finished = true;
					return;
				}
				else{
					LogService.getInstance().logBattleWin(this.hero, enemy);
				}

			}
			hero.move();
		}
	}
	
	

	
	public Boolean startBattle(Enemy enemy) { // to do : return true if hero
												// survives
		Boolean battleFinished = false;
		Boolean herosTurn = true; // at the beginning, player should attack
									// first
		while (!battleFinished) {
			if (hero.hp <= 0) {
				battleFinished = true;
				return false;
			}
			

			if (enemy.hp <= 0) {
				battleFinished = true;
				return true;

			}

			if (herosTurn) {
				hero.attack(enemy);
				herosTurn = false;
			}

			else if (!herosTurn) {
				enemy.attack(hero);
				herosTurn = true;
			}

		}
		return true;
	}
	
	public void logResult() {
		// to do : log survived or not
		App.Log((hero.hp > 0) ? "Survived" : "Dead");

	}
}
