package com.herosurvive.app;

import java.awt.List;
import java.util.ArrayList;

import com.herosurvice.models.*;
import com.herosurvive.service.*;

public class GameLogic {
	Boolean finished = false; // represented whether the resources are collected or not
	ArrayList<String> output = new ArrayList<String>();
	GameMap map = new GameMap();
	Hero hero;
	
	public GameLogic(Hero hero){
		// to do : set up game map with the parameters, the ettity classes, then invoke update()
		this.hero = hero;
	}
	
	public void start(){
		// to do : 
		// set the flag to running
		// call update method
	}
	
	public void update(){
		while(!finished){
			// to do : update hero position
			// to do : check if hero intercepts with an instance of ICharacter
			// to do : check if hero intercepts with an instance of IResource
			map.checkInterception();
			
		}
	}
}
