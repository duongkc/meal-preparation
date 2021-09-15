package com.example.ikm;

import java.util.Arrays;
import java.util.Scanner;

public class Converter {
	// bron: https://addapinch.com/cooking-conversion-charts/
	// [gram, ml, pinch, dash, teaspoon, tablespoon, cup, pint]
	String[] units = { "gram", "ml", "pinch", "dash", "teaspoon", "tablespoon", "cup", "pint" };
	double[] conversionTable = { 14.3, 15, (1.0 / 48), (1.0 / 24), (1.0 / 3), 1, 16, 32 };
	boolean continueConverter = true; // used to exit the converted when exit is typed
	static Scanner in = new Scanner(System.in);

	// Vraag de gebruiker naar input en geeft de geconverteerde waarde weer. Blijf
	// dit herhalen totdat de gebruiker 'exit' typt
	public void convert() {
		do {
			// Vraag naar invoer
			int from = requestInput(
					"What unit do you wish to convert? \nThe available options are: [gram, ml, pinch, dash, teaspoon, tablespoon, cup, pint]");
			double amount = requestAmount();
			int to = requestInput(
					"What unit do you wish to convert? \nThe available options are: [gram, ml, pinch, dash, teaspoon, tablespoon, cup, pint]");

			// Bereken het resultaat en geef het weer
			double result = 1 / (amount * conversionTable[from]) * conversionTable[to];
			System.out.printf(amount + " " + units[from] + " equals %.2f" + " " + units[to] + "\n\n", result);
		} while (continueConverter);
		in.close();
		System.out.println("You've exited the converter");
	}

	// Vraag de gebruiker naar de hoeveelheid die geconverteerd moet worden
	public double requestAmount() {
		double output = Double.NaN;
		do {
			// Blijf de gebruiker naar input vragen totdat er een finite double wordt
			// ingevoerd
			System.out.println("How much of this unit do you want to convert?");
			String input = in.nextLine();
			try {
				output = Double.parseDouble(input);
			} catch (Exception e) {
				System.out.println("This was not a number, try again");
			}
		} while (!Double.isFinite(output));
		return output;
	}

	// Vraag de gebruiker naar de eenheid die geconverteerd moet worden
	public int requestInput(String msg) {
		System.out.println(msg);
		String input = in.nextLine();
		if (Arrays.asList(units).contains(input)) {
			return Arrays.asList(units).indexOf(input);
		} else if (input.equals("exit")) {
			continueConverter = false;
			return -1;
		} else {
			return requestInput(
					"This is not a valid option, try again \nThe available options are: [gram, ml, pinch, dash, teaspoon, tablespoon, cup, pint]");
		}
	}
}
