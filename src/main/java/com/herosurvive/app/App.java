package com.herosurvive.app;

import java.io.FileNotFoundException;
import java.util.List;

import com.herosurvice.models.ErrorType;
import com.herosurvice.models.Hero;
import com.herosurvive.service.*;;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");
		// first get inputs for filenames,
		// then start the game
		HandleInput();
		GameLogic logic = new GameLogic(new Hero(12, 100, 10));
		logic.start();
	}

	public static void HandleInput() {
		String inputFileMessage = "Please enter your input file : (e.g : C:/test.input)";
		String outputFileMessage = "Please enter your output file : (e.g : C:/test.output)";
		InputLogic input = new InputLogic();
		String inputFileName = input.getInput(inputFileMessage);
		String outputFileName = input.getInput(outputFileMessage);
		if (inputFileName.trim().equals("") || outputFileName.trim().equals(""))
			LogService.getInstance().logError(ErrorType.NULLINPUTDATA);
		// keep file names on service
		DataService.getInstance().setFileNames(inputFileName, outputFileName);

		// read input string and parse
		FileLogic fileLogic = new FileLogic("");
		List<String> inputData = null;
		try {
			inputData = fileLogic.getInputFile(inputFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (inputData == null) {
			LogService.getInstance().logError(ErrorType.NULLINPUTDATA);
			return; // program ends here
		}

		// DataService.setInputData(inputData);
	}

	public static void Log(String message) {
		System.out.println(message);
	}
}
