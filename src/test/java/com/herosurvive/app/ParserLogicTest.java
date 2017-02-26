package com.herosurvive.app;

import static org.junit.Assert.*;

import java.util.List;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.herosurvive.service.FileLogic;
import com.herosurvive.service.ParserLogic;

public class ParserLogicTest {

	@Test
	public void shouldGenerateKeywords() {
		String[] data = ParserLogic.getInstance().getKeywords();
		for (String item : data) {
			App.Log(item);
		}
	}

	@Test
	public void shouldExtractNumber() throws IOException {
		int expected = 0;
		Path path = Paths.get("src/sample-input1.txt");
		FileLogic file = new FileLogic("");
		List<String> inputData = file.read(path);
		for (String item : inputData) {
			int actual = ParserLogic.getInstance().parseSpecificLine(item);
			assertEquals(expected, actual);
		}
	}
}
