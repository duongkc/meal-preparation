package com.example.ikm;


import com.google.gson.Gson;

public class RecipeReader extends FileReader 
{

	private Recipe[] recipeArray;

	public RecipeReader() 
	{
		filePath = "recipe.json";
		fileText = getJsonAsString(filePath);

		readJson();
	}

	@Override
	public void readJson() 
	{
		Gson gson = new Gson();
		recipeArray = gson.fromJson(fileText, Recipe[].class);
	}

	public Recipe[] getRecipes() 
	{
		return recipeArray;
	}
	
	/* Just a test method, can be ignored. */
	public void testing() 
	{
		Recipe r = recipeArray[1];

		System.out.println("Recipe name: " + r.getName());
		System.out.println("Kitchen: " + r.getKitchen().getName());
		for(Ingredient i : r.getIngredients()) 
		{
			System.out.println("Ingredient: " + i.getName());
		}
	}
}