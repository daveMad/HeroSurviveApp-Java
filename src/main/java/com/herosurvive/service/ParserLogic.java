package com.herosurvive.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.herosurvice.models.Enemy;
import com.herosurvice.models.Hero;
import com.herosurvice.models.ParsedData;

public class ParserLogic {
	private static ParserLogic _parser;

	public ParsedData parsedData;
	List<String> keywords;

	private ParserLogic() {
		keywords = Arrays.asList(getKeywords());
		parsedData = new ParsedData();
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
		parsedData.hero = new Hero(0, 0, 0);
		parsedData.hero.hp = parseSpecificLine(inputData.get(1));
		parsedData.hero.attackPoint = parseSpecificLine(inputData.get(2));
		// now get each enemy of unknown number
		parsedData.enemies = extractEnemies(inputData);
	}

	class EnemyDto {
		public int hp;
		public int position;
		public int attackPoint;
		public String name;

		public EnemyDto(String name) {
			this.name = name;
		}
	}

	public List<Enemy> extractEnemies(List<String> inputData) {
		List<Enemy> enemies;
		List<EnemyDto> enemyTypes = new ArrayList<EnemyDto>();

		int totalEnemyType = 0;
		int currentIndex = 3; // enemy(name) declaration starts at Line 4 =
								// index 3
		for (String item : inputData) {
			if (checkIfContainsKeyword(item, "Enemy")) {
				// extract & add the enemy type with names
				enemyTypes.add(new EnemyDto(extractEnemyType(item)));
				totalEnemyType += 1;
			}
		}

		currentIndex += totalEnemyType;
		for (int i = 0; i < enemyTypes.size(); i++) {
			// now we have enemies with names, foreach enemy, get the 2
			// lines(i,i+1) =>
			// extract hp & attackPoint from those 2 lines, respectively
			String currentenemyTypeFromLine = extractEnemyType(inputData.get(currentIndex));
			int currentEnemyHp = parseSpecificLine(inputData.get(currentIndex));
			int currentEnemyAttack = parseSpecificLine(inputData.get(currentIndex + 1));// attack
			for (EnemyDto enemyDto : enemyTypes) {
				if(enemyDto.name.equals(currentenemyTypeFromLine)){
					enemyDto.hp = currentEnemyHp;
					enemyDto.attackPoint = currentEnemyAttack;
				}
			}
			
			
			currentIndex += 2; // because we have 2 lines respectively for 1
								// enemy, increase index by 2
		}

		enemies = generateEnemiesWithPosition(inputData, currentIndex);

		for (EnemyDto item : enemyTypes) {
			for (int i = 0; i < enemies.size(); i++) {
				Enemy currentEnemy = enemies.get(i);
				if (currentEnemy.name.equals(item.name)) {
					currentEnemy.hp = item.hp;
					currentEnemy.attackPoint = item.attackPoint;

				}
			}
		}

		return enemies;
	}

	public List<Enemy> generateEnemiesWithPosition(List<String> inputData, int startingIndex) {
		List<Enemy> enemies = new ArrayList<Enemy>();
		List<String> relatedLines = inputData.subList(startingIndex, inputData.size());
		for (String line : relatedLines) {
			line = line.trim();
			if (!line.equals(""))
				enemies.add(extractEnemyWithPosition(line));
		}
		return enemies;
	}

	public Enemy extractEnemyWithPosition(String line) {
		List<String> array = Arrays.asList(line.split(" "));
		String keys = "There is a at position";
		List<String> result = new ArrayList<String>();
		for (String item : array) {
			if (keys.indexOf(item) != -1) {
				// App.Log("Should be removed!" + item);

			} else {
				result.add(item);
			}
		}
		Enemy enemy = new Enemy(result.get(0), Integer.parseInt(result.get(1)));
		return enemy;
	}

	public String extractEnemyType(String line) { // extract the enemy name w
		return line.substring(0, line.indexOf(" "));
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

		return 0; 
	}

	public Boolean checkIfContainsKeyword(String line, String keyword) {
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

		return 0; 
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
