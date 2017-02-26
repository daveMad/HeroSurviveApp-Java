package com.herosurvive.service;

import java.util.List;

import com.herosurvice.models.ParsedData;

public class ParserLogic {
	private static ParserLogic _parser;
	
	public ParsedData parsedData;
	String[] keywords;
	
	private ParserLogic(){
		keywords = getKeywords();
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
		String[] array = resourceLine.split(" ");
		for (String item : array) {
			if(checkIfNumber(item)){
				return Integer.parseInt(item);
			}
		}
		
		return 0; //
	}
	
	public String[] getKeywords(){ 
		return "resources*hero*enemy*has*attack*there is a".split("\\*");
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
