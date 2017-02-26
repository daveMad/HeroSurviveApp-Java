package com.herosurvive.service;

import java.util.List;

public class ParserLogic {
	private static ParserLogic _parser;
	
	public ParsedData parsedData;
	
	private ParserLogic(){
		
	}
	
	public static synchronized ParserLogic getInstance(){
		if(_parser == null)
			_parser = new ParserLogic();
		
		return _parser;
	}
	
	public void parseWholeFile(List<String> inputData){
		// some lines are clear,
	}
	
	public int parseResourceString(String resourceLine){ // Resources are 7500 meters away
		
	}
	
	Boolean checkIfNumber(String input){
		input = input.trim();
		try{
			Integer.parseInt(input);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
}
