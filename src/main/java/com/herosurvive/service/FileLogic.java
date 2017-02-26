package com.herosurvive.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat.Encoding;

import com.herosurvive.app.App;

public class FileLogic {
	String fileNameWithPath;
	String invalidMessage = "Not specified a valid file!";
	public FileLogic(String filePath) {
		this.fileNameWithPath = filePath;
	}

	public void read() {
		try {
			File f = new File("src/xx.txt");
			App.Log(f.getAbsolutePath());
		} catch (Exception e) {
			// TODO: handle exception
			App.Log(e.getMessage());
		}
	}

	public void readFromSpecifiedFile() throws IOException {
		String info = "Please enter the input file path (e.g : C:/file.input ):";
		InputLogic logic = new InputLogic();
		String inputFile = logic.getInput(info);
		if (inputFile.trim() == "") {
			App.Log(invalidMessage);
			return;
		}
		if(!new File(inputFile).exists());
			App.Log(invalidMessage + " : File Not Exists!");
			
		this.fileNameWithPath = inputFile;
	}

	public void readSmall() throws IOException {
		Path path = Paths.get(this.fileNameWithPath);
		List<String> lines = Files.readAllLines(path);
		for (String string : lines) {
			App.Log(string);
		}
	}

	public void writeSmall() throws IOException {
		Path path = Paths.get(this.fileNameWithPath);
		List<String> lines = Files.readAllLines(path);
		lines.add("amazed");
		Files.write(path, lines, StandardCharsets.UTF_8);

	}

}
