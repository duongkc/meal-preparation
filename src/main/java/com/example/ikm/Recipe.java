package com.example.ikm;

import java.util.Scanner;

public class Recipe 
{
	private int itemId;
	private int type;
	private int duration;
	private int portions;
	private boolean vegetarian;
	private String name;
	private String dish;
	private String kitchen;
	private String hint;
	private String[] ingredients;
	private String[] preperations;
	private String image;
	private String source;
	
	public Recipe()
	{
		// Will have to convert the String info to the classes/objects in their respective get methods.
		// I noticed that in the ingredients there's also texts like "[main]" and "[Sauce]" etc which are parts of the recipe;
	}
	
	public void setItemsId(int i)
	{
		itemId = i;
	}
	
	public int getItemId()
	{
		return itemId;
	}
	
	public void setType(int t)
	{
		type = t;
	}
	
	public int getType()
	{
		return type;
	}
	
	public void setDuration(int d)
	{
		duration = d;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setPortions(int p)
	{
		portions = p;
	}
	
	public int getPortions()
	{
		return portions;
	}
	
	public void setVegetarian(boolean v)
	{
		vegetarian = v;
	}
	
	public boolean getVegetarian()
	{
		return vegetarian;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDish(String d)
	{
		dish = d;
	}
	
	public String getDish()
	{
		return dish;
	}
	
	public void setKitchen(String k)
	{
		kitchen = k;
	}
	
	public String getKitchen()
	{
		return kitchen;
	}
	
	public void setHint(String h)
	{
		hint = h;
	}
	
	public String getHint()
	{
		return hint;
	}
	
	public void setIngredients(String[] i)
	{
		ingredients = i;
	}
	
	public String[] getIngredients()
	{
		return ingredients;
	}
	
	public void setPreperation(String[] p)
	{
		preperations = p;
	}
	
	public String[] getPreperations()
	{
		return preperations;
	}
	
	public void setImage(String i)
	{
		image = i;
	}
	
	public void setSource(String s)
	{
		source = s;
	}
	
	void adjustRecipe(Scanner sc, String[] ingredientTypes) {
		System.out.println("You are adjusting the recipe for: " + this.getName());
		System.out.println("Do you want to add an ingredient? Type 'y' for yes and 'n' for no.");
		String input = sc.nextLine();
		if (input.equals("y")) {
			addIngredient(sc, ingredientTypes);
		}
		System.out.println("Do you want to change the portions? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changePortions(sc);
		}
		System.out.println("Do you want to change the duration? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changeDuration(sc);
		}
		System.out.println("Do you want to change the preparation method? Type 'y' for yes and 'n' for no.");
		input = sc.nextLine();
		if (input.equals("y")) {
			changePreparation(sc);
		}
	}

	void addIngredient(Scanner sc, String[] ingredientTypes) {
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
				this.setVegetarian(false);
			}
		}
		
		//Ingredient[] newIngredients = new Ingredient[recipe.getIngredients().length + 1];
		String[] newIngredients = new String[this.getIngredients().length + 1];
		for (int i = 0; i < this.getIngredients().length; i++) {
			newIngredients[i] = this.getIngredients()[i];
		}
		newIngredients[this.getIngredients().length] = inputIngredient.name;
		this.setIngredients(newIngredients);
	}

	void changePreparation(Scanner sc) {
		System.out.println("Please insert the new preparation. Type 'done' when you are done.");
		String[] newPreparations = new String[0];
		while (sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("done")) {
				break;
			}
			addStringtoArray(newPreparations, nextLine);
		}
		System.out.println("New preparation: " + newPreparations);
		this.setPreperation(newPreparations);
	}

	private String[] addStringtoArray(String[] array, String string) {
		String[] newArray = new String[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[array.length] = string;
		return newArray;
	}

	void changePortions(Scanner sc) {
		System.out.println("Please insert the new number of portions.");
		int newPortions = Integer.parseInt(sc.nextLine());
		this.setPortions(newPortions);
	}

	void changeDuration(Scanner sc) {
		System.out.println("Please insert the new duration.");
		int newDuration = Integer.parseInt(sc.nextLine());
		this.setDuration(newDuration);
	}

}
