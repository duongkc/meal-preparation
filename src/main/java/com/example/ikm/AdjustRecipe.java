package com.example.ikm;

import java.util.Scanner;

public class AdjustRecipe {

	void adjustRecipe(Recipe recipe) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to add an ingredient? Type 'y' for yes and 'n' for no.");
		String input = sc.nextLine();
		if (input.equals("y")) {
			addIngredient(recipe, sc);
		}
		System.out.println("Do you want to change the preparation method? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changePreparation(recipe, sc);
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
		sc.close();
	}
	
	void addIngredient(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the name of the ingredient.");
		// Dit voeg nog alleen het ingredient toe, je moet ook kunnen toevoegen hoeveel
		// er per persoon door moet. Of houden we dat bij in de naam?
		String inputIngredientName = sc.nextLine();
		
		Ingredient inputIngredient = new Ingredient();
		inputIngredient.name = inputIngredientName;
		// Checken of dit ingredient een type heeft en dan toevoegen --> dan ook checken of nog vega.
		
		Ingredient[] newIngredients = new Ingredient[recipe.ingredients.length + 1];
		for (int i = 0; i < recipe.ingredients.length; i++) {
			newIngredients[i] = recipe.ingredients[i];
		}
		newIngredients[recipe.ingredients.length] = inputIngredient;
		recipe.ingredients = newIngredients;
	}
	
	void changePreparation(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the new preparation");
		String newPreparation = "";
		while(sc.hasNextLine()) {
			newPreparation += sc.nextLine();
		}
		System.out.println("New preparation: " + newPreparation);
		recipe.preparation = newPreparation;
	}
	
	void changePortions(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the new number of portions.");
		int newPortions = sc.nextInt();
		recipe.portions = newPortions;
	}

	void changeDuration(Recipe recipe, Scanner sc) {
		System.out.println("Please insert the new duration.");
		int newDuration = sc.nextInt();
		recipe.duration = newDuration;
		
	}

}
