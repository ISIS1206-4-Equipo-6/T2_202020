package main;


import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

import controller.Controller;

public class Main {

	public static void main(String[] args) throws IOException, CsvValidationException 
	{
		Controller controler = new Controller();
		controler.run();
	}
}
