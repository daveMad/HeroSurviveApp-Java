package com.herosurvive.app;

import com.herosurvice.models.Hero;
import com.herosurvive.service.InputLogic;;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		GameLogic logic = new GameLogic(new Hero(12, 100, 10));
		logic.start();
	}

	public static void Log(String message) {
		System.out.println(message);
	}
}
