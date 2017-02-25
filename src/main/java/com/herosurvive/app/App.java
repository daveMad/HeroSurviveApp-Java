package com.herosurvive.app;

import com.herosurvive.service.InputLogic;;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		InputLogic inputLogic = new InputLogic();
		Log(inputLogic.getInput("Some kinda"));
	}

	public static void Log(String message) {
		System.out.println(message);
	}
}
