package com.example.ikm;

<<<<<<< HEAD
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
	// Deze boolean moet hier staan om in addIngredient methode de status van het recept te
	// kunnen aanpassen als er vlees wordt toegevoegd.
	boolean vegetarian;

	public Recipe(String id, String name, int duration, Ingredient[] ingredients, String preparation, int portions,
			String hint, String dish, String kitchen) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.portions = portions;
		this.hint = hint;
		this.dish = dish;
		this.kitchen = kitchen;
=======
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
>>>>>>> master
	}
	
}
