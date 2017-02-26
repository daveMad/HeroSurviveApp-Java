package com.herosurvive.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.herosurvive.service.ParserLogic;

public class ParserLogicTest {

	@Test
	public void shouldGenerateKeywords() {
		String[] data = ParserLogic.getInstance().getKeywords();
		for (String item : data) {
			App.Log(item);
		}
	}

}
