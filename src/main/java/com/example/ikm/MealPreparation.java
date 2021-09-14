package com.example.ikm;

//import com.fasterxml.jackson.core.JsonFactory;

import java.util.Scanner;

/**
 * Class to
 *
 * @author Imke, Kim, Melany, Rick
 * @version 1.0
 */
public class MealPreparation {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		Ingredient[] ingredientList = new Ingredient[2];
		ingredientList[0] = new Ingredient();
		ingredientList[0].name = "lettuce";
		ingredientList[0].type = "vegetable";
		ingredientList[1] = new Ingredient();
		ingredientList[1].name = "tomato";
		ingredientList[1].type = "vegetable";
		String[] ingredientTypes = {"vegetables", "dairy", "meat"};
		Food testRecipe = new Food("9999", "Simple salad", 20, ingredientList, "add the ingredients and mix in a bowl", 2,
				"add some chilli for an extra punch.", "Side dish", "other", true);
		AdjustRecipe adjust = new AdjustRecipe();
		adjust.adjustRecipe(testRecipe, s, ingredientTypes);
		
		System.out.println("Welcome to the Meal Prepper!");
		System.out.println("What would you like to do?");
		System.out.println("Press 'a' if you want a meal suggestion based on what's in your fridge"
				+ "\nPress 'b' if you want a random meal suggestion" + "\nPress 'c' to show all recipes");
		startChoice();
		// JsonFactory jsonFactory = new JsonFactory();

	}

	private static void startChoice() {
		// noinspection InfiniteLoopStatement
		while (true) {
			String pick = s.nextLine();
			if ("a".equals(pick) || "b".equals(pick) || "c".equals(pick)) {
				run(pick);
			} else {
				System.out.println("Please type 'a', 'b' or 'c'");
			}
		}
	}

	private static void run(String pick) {
		System.out.println("You've picked something: " + pick);

	}

	static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
