package com.herosurvive.service;
import java.util.ArrayList;

import com.herosurvice.models.*;
public class GameMap {
	IHero hero;
	ArrayList<IEnemy> enemies;
	int endPosition = 0;
	
	public GameMap(IHero hero,ArrayList<IEnemy> enemies,int endPosition){
		this.hero = hero;
		this.enemies = enemies;
		this.endPosition = endPosition;
	}
	
	public void checkInterception() {
		
		
	}
	
	public bool arriveEndPoint(){
		// to do : return whether hero.position equals to this.end
	}
	
	

}
