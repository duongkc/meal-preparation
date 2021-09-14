package com.example.ikm;

public abstract class Recipe {
	final String id;
	final String name;
	int duration;
	Ingredient[] ingredients;
	String preparation;
	int portions;
	final String hint;
	final String dish;
	final String kitchen;
	boolean vegetarian;

	public Recipe(String id, String name, int duration, Ingredient[] ingredients, String preparation, int portions,
			String hint, String dish, String kitchen, boolean vegetarian) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.portions = portions;
		this.hint = hint;
		this.dish = dish;
		this.kitchen = kitchen;
		this.vegetarian = vegetarian;
	}
}
