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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat.Encoding;

import com.herosurvive.app.App;

public class FileLogic {
	String fileNameWithPath;
	String invalidMessage = "Not specified a valid file!";
	String fileNotFoundMessage = invalidMessage + " : File Not Exists!";
	InputLogic logic;

	public FileLogic(String filePath) {
		this.fileNameWithPath = filePath;
		this.logic = new InputLogic();
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
		String inputFile = logic.getInput(info);
		if (inputFile.trim() == "") {
			App.Log(invalidMessage);
			return;
		}
		if (!new File(inputFile).exists())
			App.Log(fileNotFoundMessage + inputFile);

		this.fileNameWithPath = inputFile;
		readSmall();
	}

	public void writeToSpecifiedFile() throws IOException {
		String info = "Please enter the output file path (e.g : C:/file.output ):";
		String outputFile = logic.getInput(info);
		if (outputFile.trim() == "") {
			App.Log(invalidMessage);
			return;
		}

		if (!new File(outputFile).exists())
			App.Log(fileNotFoundMessage + " : " + outputFile + " A new file with this name'll be created");
		
		App.Log("");
		
		this.fileNameWithPath = outputFile;
		Path path = Paths.get(outputFile);
		write(path, getSampleData());

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
		
		write(path, getSampleData());
	}
	
	
	List<String> read(Path path) throws IOException {
		try {
			if (!new File(this.fileNameWithPath).exists())
				throw new FileNotFoundException(this.fileNotFoundMessage);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Files.readAllLines(path);
	}

	void write(Path path, List<String> data) {
		try {
			Files.write(path, data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<String> getSampleData(){
		List<String> lines = new ArrayList<String>();
		lines.add("amazed by writing skills!");
		return lines;
	}

	public String getInputFile() {
		List<String> inputData = read(path);
		DataService.getInstance().setData(inputData);
	}


}
