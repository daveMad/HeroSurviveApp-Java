package com.herosurvive.app;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.herosurvive.service.*;

public class FileLogicTest {

	@Test
	public void shouldReturnEverythinInTextFile() {
		FileLogic fLogic = new FileLogic("src/test.input");
		try {
			fLogic.readSmall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldWriteToExistingFile(){
		FileLogic logic = new FileLogic("src/sample-input1.txt");
		try {
			logic.writeSmall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
