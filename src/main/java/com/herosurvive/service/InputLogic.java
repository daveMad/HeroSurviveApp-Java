package com.herosurvive.service;

import java.lang.System;
import java.security.GeneralSecurityException;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputLogic {
	
	
	
	public String getInput(String infoMessage) {
		// inform user about what kind of data should be entered
		System.out.println(infoMessage);

		InputStreamReader streamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(streamReader);
		String input = "";
		try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return input;
	}
	
	
	

}
