package com.example.ikm;

import java.util.ArrayList;

/* Makes sure the Recipe Class gives back the right objects if asked. */
public class RecipeController 
{
	// These list all Dishes/Kitchen/Ingredients to exsist in the app.
	private static ArrayList<Dish> dishList = new ArrayList<Dish>();
	private static ArrayList<Kitchen> kitchenList = new ArrayList<Kitchen>();
	private static ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	public ArrayList<Dish> getDishList()
	{
		return dishList;
	}
	
	public ArrayList<Kitchen> getKitchenList()
	{
		return kitchenList;
	}
	
	public ArrayList<Ingredient> getIngredientList()
	{
		return ingredientList;
	}
	
	public void addDishToList(Dish dish) 
	{
		if(!dishList.contains(dish)) 
		{
			dishList.add(dish);
		}
	}
	
	public void addKitchenToList(Kitchen kitchen) 
	{
		kitchenList.add(kitchen);
	}
	
	public void addIngredientToList(Ingredient ingredient) 
	{
		ingredientList.add(ingredient);
	}
	
	public void addDishToList(String dish) 
	{
		Dish d = convertStringToDish(dish);
		
		if(!dishList.contains(d)) 
		{
			dishList.add(d);
		}
	}
	
	public void addKitchenToList(String kitchen)
	{
		Kitchen k = convertStringToKitchen(kitchen);
		
		if(!kitchenList.contains(k)) 
		{
			kitchenList.add(k); 
		}
	}
	
	/* Will be called by the Recipe class. Give a String name and get back the Dish object if it exists, or gets back a new Dish object with the given name. */
	public Dish convertStringToDish(String dishName) 
	{
		for(Dish d : dishList)
		{
			if(dishName.toLowerCase().equals(d.getName().toLowerCase())) 
			{
				return d;
			}
		}
		
		Dish dish = new Dish(dishName);
		addDishToList(dish);
		
		return dish;
	}
	
	/* Will be called by the Recipe class. Give a String name and get back the Kitchen object if it exists, or gets back a new Kitchen object with the given name. */
	public Kitchen convertStringToKitchen(String kitchenName) 
	{
		for(Kitchen k : kitchenList) 
		{
			if(kitchenName.toLowerCase().equals(k.getName().toLowerCase())) 
			{
				return k;
			}
		}
		
		Kitchen kitchen = new Kitchen(kitchenName);
		return kitchen;
	}
	
	/* Will be called by the Recipe class. Give a String name and get back the Ingredient object if it exists, or gets back a new Ingredient object with the given name. */
	public Ingredient convertStringToIngredient(String ingredientName) 
	{
		 for(Ingredient i: ingredientList) 
		 {
			 if(ingredientName.toLowerCase().equals(i.getName().toLowerCase()))
			 {
				 return i;
			 }
		 } 
		 
		 Ingredient ingredient = new Ingredient(ingredientName);
		 return ingredient;
	}
	
	/* Will be called by the Recipe class. Give a String Array and get back an Ingredient Array. */
	public Ingredient[] convertStringArrayToIngredientArray(String[] ingredientArray) 
	{
		Ingredient[] ingredientList = new Ingredient[ingredientArray.length];
		
		for(int i = 0; i < ingredientArray.length; i++) 
		{
			ingredientList[i] = convertStringToIngredient(ingredientArray[i]);
		}
		
		return ingredientList;
	}
}
