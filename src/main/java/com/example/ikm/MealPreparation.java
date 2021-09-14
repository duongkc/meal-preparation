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
public class MealPreparation
{
	private static Recipe[] recipeArray;
    static Scanner s = new Scanner(System.in);
    

    public static void main(String[] args) 
    {
        // Test recipe to try out code: can be deleted in later stages
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
		Drink testRecipe2 = new Drink("9999", "Simple salad", 20, ingredientList, "add the ingredients and mix in a bowl", 2,
				"add some chilli for an extra punch.", "Side dish", "other");
		AdjustRecipe adjust = new AdjustRecipe();
		adjust.adjustRecipe(testRecipe, s, ingredientTypes);
		// End of testing code to adjust recipe.

    	recipeArray = new FileReader().getRecipes();
    	
        System.out.println("Welcome to the Meal Prepper!");
        System.out.println("What would you like to do?");
        System.out.println("Press 'a' if you want a meal suggestion based on what's in your fridge" +
                "\nPress 'b' if you want a random meal suggestion" +
                "\nPress 'c' to show all recipes");
        startChoice();
    }

    private static void startChoice() {
        boolean active = true;
        while (active) {
            String pick = s.nextLine();
            if ("a".equals(pick) || "b".equals(pick) || "c".equals(pick)) {
                run(pick);
                active = false;
            } else {
                System.out.println("Please type 'a', 'b' or 'c'");
            }
        }

    }

    private static void run(String pick) {
        System.out.println("You've picked something: " + pick);
            if ("a".equals(pick)){
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
                while (!done){
                    String ingredient = s.nextLine();
                    if (ingredient.equals("done")){

                        done = true;
                    } else if (recipeIngredients.contains(ingredient)){
                        // code that add ingredients to a list to compare with recipe later
                        //if list already contains earlier typed ingredient
                        if (!fridgeContents.contains(ingredient)){
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
