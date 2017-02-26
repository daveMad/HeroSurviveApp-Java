package com.herosurvive.service;
import java.util.ArrayList;

import com.herosurvice.models.*;
public class GameMap {
	Hero hero;
	ArrayList<Enemy> enemies;
	int endPosition = 0;
	
	public GameMap(Hero hero,ArrayList<Enemy> enemies,int endPosition){
		this.hero = hero;
		this.enemies = enemies;
		this.endPosition = endPosition;
	}
	
	public ICharacter checkInterception() {
		for (Enemy enemy : enemies) {
			if(hero.position == enemy.position){
				return enemy;
			}
		}
		
		return null;
	}
	
	public Boolean heroAtEndPoint(){
		// to do : return whether hero.position equals to this.end
		return hero.position >= this.endPosition;
	}
	
	

}
