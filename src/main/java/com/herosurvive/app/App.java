package com.herosurvive.app;

import com.herosurvice.models.Hero;
import com.herosurvive.service.*;;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");
		// first get inputs for filenames,
		// then start the game
		
		GameLogic logic = new GameLogic(new Hero(12, 100, 10));
		
		logic.start();
	}
	
	void HandleInput(){
		FileLogic fileLogic = new FileLogic("");
		fileLogic.getInputFile(); // get input file
		fileLogic.getOutputFile();
	}

	public static void Log(String message) {
		System.out.println(message);
	}
}
