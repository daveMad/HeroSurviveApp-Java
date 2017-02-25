package com.herosurvive.app;

import java.awt.List;
import java.util.ArrayList;

import com.herosurvice.models.*;
import com.herosurvive.service.*;

public class GameLogic {
	Boolean finished; // represented whether the resources are collected
								// or not
	ArrayList<String> output = new ArrayList<String>();
	GameMap map;
	Hero hero;

	public GameLogic(Hero hero) {
		// to do : set up game map with the parameters, the ettity classes, then
		// invoke update()
		this.hero = hero;
	}

	public void start() {
		// to do :
		// set the flag to running
		// call update method
		finished = false;
		update();
	}

	public void update() {
		while (!finished) {
			// to do : update hero position
			// to do : check if hero intercepts with an instance of ICharacter
			// to do : check if hero at the end point (Resource location point)
			if (map.heroAtEndPoint())
				logResult();
			Enemy enemy = (Enemy) map.checkInterception();
			if (enemy != null) { // to do : start an attack
				if (!startBattle(enemy)) {
					finished = true;
					continue;
				}

			}

			hero.move();

		}
	}

	public void logResult() {
		// to do : log survived or not
		App.Log((hero.hp > 0) ? "Survived" : "Dead");

	}

	public Boolean startBattle(Enemy enemy) { // to do : return true if hero
												// survives
		Boolean battleFinished = false;
		Boolean herosTurn = true; // at the beginning, player should attack
									// first
		while (!battleFinished) {
			if (hero.hp <= 0)
				return false;

			if (enemy.hp <= 0)
				return true;

			if (herosTurn) {
				hero.attack(enemy);
				herosTurn = false;
			}

			else {
				enemy.attack(hero);
				herosTurn = true;
			}

		}
		return true;
	}
}
