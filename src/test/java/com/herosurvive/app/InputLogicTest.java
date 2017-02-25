package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.herosurvive.service.InputLogic;

public class InputLogicTest {
	
	InputLogic repo = new InputLogic();
	
	@Test
	public void getInputShouldReturnTest() {
		String input = "Some";
		assertNotNull(repo.getInput(input));
	}

}
