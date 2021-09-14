package com.example.ikm;

import java.util.Scanner;

public class AdjustRecipe {

	void adjustRecipe(Recipe recipe, Scanner sc, String[] ingredientTypes) {
		System.out.println("You are adjusting the recipe for: " + recipe.name);
		System.out.println("Do you want to add an ingredient? Type 'y' for yes and 'n' for no.");
		String input = sc.nextLine();
		if (input.equals("y")) {
			addIngredient(recipe, sc, ingredientTypes);
		}
		System.out.println("Do you want to change the portions? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changePortions(recipe, sc);
		}
		System.out.println("Do you want to change the duration? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changeDuration(recipe, sc);
		}
		System.out.println("Do you want to change the preparation method? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changePreparation(recipe, sc);
		}
	}

	void addIngredient(Recipe recipe, Scanner sc, String[] ingredientTypes) {
		System.out.println("Please insert the name of the ingredient.");
		// Dit voegt nog alleen het ingredient toe, je moet ook kunnen toevoegen hoeveel
		// er per persoon door moet. Of houden we dat bij in de naam?
		String inputIngredientName = sc.nextLine();

		Ingredient inputIngredient = new Ingredient();
		inputIngredient.name = inputIngredientName;

		// Checken of dit ingredient een type heeft en dan toevoegen --> dan ook checken
		// of nog vega.
		System.out.println(
				"Is this ingredient of one of the following categories? Press '1' if it belongs in the first category, '2' if it belongs in the second, etc.");
		for(int i = 0; i < ingredientTypes.length; i++) {
			int num = i + 1;
			System.out.println(num + ". " + ingredientTypes[i]);
		}
		
		int idx = Integer.parseInt(sc.nextLine()) - 1;
		if (idx >= 0 & idx < ingredientTypes.length) {
			inputIngredient.type = ingredientTypes[idx];
			if(inputIngredient.type.equals("meat")) {
				recipe.vegetarian = false;
			}
		}
		
		Ingredient[] newIngredients = new Ingredient[recipe.ingredients.length + 1];
		for (int i = 0; i < recipe.ingredients.length; i++) {
			newIngredients[i] = recipe.ingredients[i];
		}
		newIngredients[recipe.ingredients.length] = inputIngredient;
		recipe.ingredients = newIngredients;
	}

	void changePreparation(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the new preparation. Type 'done' when you are done.");
		String newPreparation = "";
		while (sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("done")) {
				break;
			}
			newPreparation += nextLine + "\n";
		}
		System.out.println("New preparation: " + newPreparation);
		recipe.preparation = newPreparation;
	}

	void changePortions(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the new number of portions.");
		int newPortions = Integer.parseInt(sc.nextLine());
		recipe.portions = newPortions;
	}

	void changeDuration(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the new duration.");
		int newDuration = Integer.parseInt(sc.nextLine());
		recipe.duration = newDuration;
	}

}
