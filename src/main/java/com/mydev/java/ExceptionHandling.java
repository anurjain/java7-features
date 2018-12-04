package com.mydev.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ExceptionOne extends Exception {
	
}

class ExceptionTwo extends Exception {
	
}

public class ExceptionHandling {

	public static void main(String[] args) {
		
		try {
			mymethod ("Two");
			readFirstLineFromFile("test.txt");
		} catch (ExceptionTwo | ExceptionOne | IOException e) { //catch both exceptions here
			e.printStackTrace();
		}

	}

	public static void mymethod (String param) throws ExceptionTwo, ExceptionOne {
		if (param.equals("One"))
			throw new ExceptionOne ();
		else
			throw new ExceptionTwo ();
	}
	
	static String readFirstLineFromFile(String path) throws IOException {
		  try (BufferedReader br = new BufferedReader(new FileReader(path))) { // try with resources as it implements java.lang.AutoCloseable,
		    return br.readLine();
		  }
		}
}
