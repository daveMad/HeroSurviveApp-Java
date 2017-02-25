package com.herosurvive.app;

import java.awt.List;
import java.util.ArrayList;

import com.herosurvice.models.*;
import com.herosurvive.service.*;

public class GameLogic {
	Boolean finished = false; // represented whether the resources are collected or not
	ArrayList<String> output = new ArrayList<String>();
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
		}
	}
}
