package com.herosurvive.app;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.herosurvive.service.*;

public class FileLogicTest {
	FileLogic logic;
	@Test
	public void shouldReturnEverythinInTextFile() {
		 logic = new FileLogic("src/test.input");
		try {
			logic.readSmall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldWriteToExistingFile(){
		 logic = new FileLogic("src/sample-input1.txt");
		try {
			logic.writeSmall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void userShouldEnterValidFile(){
		 logic = new FileLogic("src/test.input");
		 try {
			logic.readFromSpecifiedFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldWriteToSpecifiedFile(){
		logic = new FileLogic("src/test.input");
		try {
			logic.writeToSpecifiedFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
