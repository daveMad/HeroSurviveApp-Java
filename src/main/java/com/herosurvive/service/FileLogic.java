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

import com.herosurvive.app.App;

public class FileLogic {
	String fileNameWithPath;
	public FileLogic(String filePath){
		this.fileNameWithPath = filePath;
	}
	
	public void read(){
		try {
			File f = new File("src/x.txt");
		} catch (Exception e) {
			// TODO: handle exception
			App.Log(e.getMessage());
		} 
	}
	
	
}
