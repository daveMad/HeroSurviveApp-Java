package com.herosurvive.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.herosurvice.models.Enemy;
import com.herosurvice.models.ParsedData;

public class ParserLogic {
	private static ParserLogic _parser;

	public ParsedData parsedData;
	List<String> keywords;

	private ParserLogic() {
		keywords = Arrays.asList(getKeywords());
	}

	public static synchronized ParserLogic getInstance() {
		if (_parser == null)
			_parser = new ParserLogic();

		return _parser;
	}

	public void parseWholeFile(List<String> inputData) {
		// some lines are clear, 0 = Resource & 1 = Hero.hp & 2 =
		// Hero.attackpoint & 2-EnemyEndPoint = Enemy declaration &
		// EnemyEndPoint-FileEndPoint = Enemies.forEach(e => return e.position)
		parsedData.resourcePoint = parseSpecificLine(inputData.get(0));
		parsedData.hero.hp = parseSpecificLine(inputData.get(1));
		parsedData.hero.attackPoint = parseSpecificLine(inputData.get(2));
		// now get each enemy of unknown number

		List<Enemy> enemies;

		// get the known number of enemies position
	}
	
	public List<Enemy> extractEnemies(List<String> inputData){
		List<Enemy> enemies = new ArrayList<Enemy>();
		int index = 3; // enemy declaration starts at Line 4 = index 3
		while(index < inputData.size()){
			for (String item : inputData) {
				if(checkIfContainsKeyword(item, "Enemy")){
					// extract & add the enemy to the return result list
				}
			}
		}
		
		return null;
	}
	
	public Enemy extractEnemyName(String line){ // extract the enemy name w
		return new Enemy(line.substring(0,line.indexOf("")));
	}
	
	class RandomData {
		String propName;
		Object value;

		public String getPropName() {
			return propName;
		}

		public void setPropName(String propName) {
			this.propName = propName;
		}

	}

	public RandomData parseRandomLine(String str){
		RandomData result = new RandomData();
		String[] array = str.split(" ");
		for (String item : array) {
			item = item.toLowerCase();
			if(keywords.indexOf(item) != -1){
				String temp =keywords.get(keywords.indexOf(item));
				if(temp == "enemy"){ // due to jdk 1.8 possible issues, used if blocks instead of switch
					result.propName = "Enemy.name";
					result.value = array[0]; // *Bug* is Enemy
				}else if(temp == "has"){
					result.propName = "Enemy.hp";
					result.value = Integer.parseInt(array[2]); // hp value stands right before the last word of the sentence
				} else if(temp == "attack"){
					result.propName = "Enemy.attackPoint";
					result.value = Integer.parseInt(array[array.length - 1]); // attack is the last word
				} else if(temp == "position"){
					result.propName = "Enemy.position";
					result.value = Integer.parseInt(array[array.length - 1]); // position is the last word
				}
			}
		}
		
		return null;
	}

	public int parseSpecificLine(String resourceLine) { // Example : Resources
														// are 7500
														// meters away
		String[] array = resourceLine.split(" ");
		for (String item : array) {
			if (checkIfNumber(item)) {
				return Integer.parseInt(item);
			}
		}

		return 0; //
	}
	
	public Boolean checkIfContainsKeyword(String line,String keyword){
		List<String> words = Arrays.asList(line.split(" "));
		return words.indexOf(keyword) != -1;
	}

	public String[] getKeywords() {
		return "resources*hero*enemy*has*attack*there is a".split("\\*");
	}

	public int extractNumber(String[] inputArray) {
		for (String item : inputArray) {
			if (checkIfNumber(item) == true)
				return Integer.parseInt(item);
		}

		return 0; // return
	}

	Boolean checkIfNumber(String input) {
		input = input.trim();
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
