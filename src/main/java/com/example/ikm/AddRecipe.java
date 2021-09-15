package com.example.ikm;

import java.util.Scanner;

public class AddRecipe {
	
	Recipe addRecipe(Scanner sc) throws Exception{
		int itemId;
		//int type;
		//int duration;
		//int portions;
		//boolean vegetarian;
		//String dish;
		//String kitchen;
		//String hint;
		String[] ingredients;
		//String[] preperations;
		//String image;
		//String source;
		
		Recipe recipe = new Recipe();
		// get highest ItemID of existing recipes and increment by 1 for recipe.setItemID(); 
		
		// Add name
		System.out.println("What is the name of the recipe you would like to add?");
		recipe.setName(sc.nextLine());
		
		// Add type: food or drink.
		System.out.println("Is it food or drink?");
		String ans = sc.nextLine();
		if(ans.equals("Food") || ans.equals("food") || ans.equals("Drink")  || ans.equals("drink")) {
			int type = 0;
			if(ans.equals("Drink") || ans.equals("drink")) {
				type = 1;
			}
			recipe.setType(type);
		} else {
			throw new WrongRecipeInputException("Please type only Food or Drink.");
		}
		
		// Add Ingredients
		
		// Add vegetarian
		System.out.println("Is the dish vegetarian? Type 'y' for yes and 'n' for no.");
		String vegetarian = sc.nextLine();
		if(vegetarian.equals("n") || vegetarian.equals("y")) {
			if(vegetarian.equals("y")) {
				recipe.setVegetarian(true);
			} else {
				recipe.setVegetarian(false);
		}	
		} else {
			throw new WrongRecipeInputException("You could only answer 'y' or 'n' to this question.");
		}
		// Add dish
		System.out.println("What kind of dish is the recipe for? Think of: Soup, Main, Side, Cocktail, etc.");
		String dish = sc.nextLine();
		recipe.setDish(dish);
		
		// Add kitchen
		System.out.println("From what kind of kitchen is the recipe? Think of: Thai, French, etc., or choose other if unknown.");
		String kitchen = sc.nextLine();
		recipe.setKitchen(kitchen);
		
		// Add duration
		System.out.println("How many minutes does it take to prepare the recipe? Please give your answer in numbers.");
		int duration = Integer.parseInt(sc.nextLine());
		recipe.setDuration(duration);
		
		// Add portions
		System.out.println("How many portions does the recipe serve? Please give your answer in numbers.");
		int portions = Integer.parseInt(sc.nextLine());
		recipe.setPortions(portions);
		
		// Add preparations
		System.out.println("Please insert the preparations. Type 'done' when you are done.");
		String[] preparations = new String[0];
		while (sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("done")) {
				break;
			}
			preparations = addStringtoArray(preparations, nextLine);
		}
		recipe.setPreperation(preparations);
		
		// Optionally add hint to recipe
		System.out.println("Would you like to add a hint? Type 'y' for yes and 'n' for no.");
		ans = sc.nextLine();
		if(ans.equals("y") || ans.equals("n")) {
			if(ans.equals("y")) {
				System.out.println("Please type your hint here: ");
				String hint = sc.nextLine();
				recipe.setHint(hint);
			}
		} else {
			throw new WrongRecipeInputException("You could only answer 'y' or 'n' to this question.");
		}
		
		// Optionally add image to recipe
		System.out.println("Would you like to add an image? Type 'y' for yes and 'n' for no.");
		ans = sc.nextLine();
		if(ans.equals("y") || ans.equals("n")) {
			if(ans.equals("y")) {
				System.out.println("Please type the url to your image here: ");
				String image = sc.nextLine();
				recipe.setImage(image);
			}
		} else {
			throw new WrongRecipeInputException("You could only answer 'y' or 'n' to this question.");
		}
		
		// Optionally add source to recipe
		System.out.println("Would you like to add a source? Type 'y' for yes and 'n' for no.");
		ans = sc.nextLine();
		if(ans.equals("y") || ans.equals("n")) {
			if(ans.equals("y")) {
				System.out.println("Please type the url to your source here: ");
				String source = sc.nextLine();
				recipe.setSource(source);
			}
		} else {
			throw new WrongRecipeInputException("You could only answer 'y' or 'n' to this question.");
		}
		return recipe;
	}

	private String[] addStringtoArray(String[] array, String string) {
		String[] newArray = new String[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[array.length] = string;
		return newArray;
		
	}

	
}
