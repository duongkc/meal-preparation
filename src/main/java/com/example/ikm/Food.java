package com.example.ikm;

public class Food extends Recipe
{
	boolean vegetarian;
	
	public Food(String id, String name, int duration, Ingredient[] ingredients, String preparation, int portions,
			String hint, String dish, String kitchen, boolean vegetarian) {
		super(id, name, duration, ingredients, preparation, portions, hint, dish, kitchen);
		this.vegetarian = vegetarian;
	}

}
