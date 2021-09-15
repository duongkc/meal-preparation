package com.example.ikm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to
 *
 * @author Imke, Kim, Melany, Rick
 * @version 1.0
 */
public class MealPreparation {
	private static Recipe[] recipeArray;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		recipeArray = new FileReader().getRecipes();

		System.out.println("Welcome to the Meal Prepper!");
		System.out.println("What would you like to do?");
		System.out.println("Press 'a' if you want a meal suggestion based on what's in your fridge"
				+ "\nPress 'b' if you want a random meal suggestion" + "\nPress 'c' to show all recipes"
				+ "\nPress 'd' to adjust a recipe." + "\nPress 'e' to convert measurements.");
		startChoice();
	}

	private static void startChoice() {
		boolean active = true;
		while (active) {
			String pick = s.nextLine();
			if ("a".equals(pick) || "b".equals(pick) || "c".equals(pick) || "d".equals(pick) || "e".equals(pick)) {
				run(pick);
				active = false;
			} else {
				System.out.println("Please type 'a', 'b', 'c', 'd' or 'e'");

			}
		}

	}

	private static void run(String pick) {
		System.out.println("You've picked something: " + pick);
		if ("a".equals(pick)) {
			ArrayList<String> recipeIngredients = new ArrayList<>();

			// Use loop with available ingredients in every recipe later on
			recipeIngredients.add("egg");
			recipeIngredients.add("milk");
			recipeIngredients.add("potato");
			System.out.println("What's in your fridge? Choose from the following:");
			System.out.println(recipeIngredients);
			System.out.println("Type 'done' when you're done");

			boolean done = false;
			List<String> fridgeContents = new ArrayList<>();
			while (!done) {
				String ingredient = s.nextLine();
				if (ingredient.equals("done")) {

					done = true;
				} else if (recipeIngredients.contains(ingredient)) {
					// code that add ingredients to a list to compare with recipe later
					// if list already contains earlier typed ingredient
					if (!fridgeContents.contains(ingredient)) {
						fridgeContents.add(ingredient);
						System.out.println("Great! what else?");
					} else {
						System.out.println("You've already listed this, add something else?");
					}

				} else {
					System.out.println("Please pick valid ingredients from the list.");
				}
			}
			System.out.println("You have this in your fridge : " + fridgeContents);
			System.out.println("Generating recipe...");
			wait(2000);
			System.out.println("How about [.........]?");

		} else if ("b".equals(pick)) {
			System.out.println("Here's a random recipe: ");
			System.out.println("How about [.........]?");
		} else if ("c".equals(pick)) {
			System.out.println("Here's a list of all available recipes: ");
		} else if ("d".equals(pick)) {

			System.out.println("Type 'a' to add a new recipe and 'b' to adjust an existing recipe");
			String ans = s.nextLine();
			
			if ("a".equals(ans)) {
				AddRecipe addRecipe = new AddRecipe();
				try {
					Recipe[] newRecipeArray = new Recipe[recipeArray.length + 1];
					for (int i = 0; i < recipeArray.length; i++) {
						newRecipeArray[i] = recipeArray[i];
					}
					newRecipeArray[recipeArray.length] = addRecipe.addRecipe(s, recipeArray);
					recipeArray = newRecipeArray;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if ("b".equals(ans)) {
				System.out.println("Please enter the name of the recipe you would like to adjust.");
				String recipeName = s.nextLine();
				int count = 0;
				while (count == 0) {
					for (int i = 0; i < recipeArray.length; i++) {
						if (recipeArray[i].getName().equals(recipeName)) {
							String[] ingredientTypes = { "dairy", "vegetables", "meat" };
							recipeArray[i].adjustRecipe(s, ingredientTypes);
							count++;
						}
					}
					if (count == 0) {
						System.out.println("Please enter a valid recipe name.");
						recipeName = s.nextLine();
					}

				}
			}

		}

		} else if ("e".equals(pick)) {
			new Converter().convert();
		}
	}

	static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
