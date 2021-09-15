package com.example.ikm;

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
	private RecipeController recipeController = new RecipeController();
	
	public Recipe()
	{
		// Will have to convert the String info to the classes/objects in their respective get methods.
		// I noticed that in the ingredients there's also texts like "[main]" and "[Sauce]" etc which are parts of the recipe;
	}
	
	public Recipe(int itemId, int type, int duration, int portions, boolean vegetarian, String name, String dish, String kitchen, String hint, String[] ingredients, String[] preperations) 
	{
		this.itemId = itemId;
		this.type = type;
		this.duration = duration;
		this.portions = portions;
		this.vegetarian = vegetarian;
		this.name = name;
		this.dish = dish;
		this.kitchen = kitchen;
		this.hint = hint;
		this.ingredients = ingredients;
		this.preperations = preperations;
		// Ignoring "image" & "source" since this is used by user input.
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
	
	public String getType()
	{
		if(type == 0) 
		{
			return "Food";
		}
		else if (type == 1) 
		{
			return "Drink";
		}
		
		return null;
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
	
	/* Returns the Dish object of the String dish variable using RecipeController. */
	public Dish getDish()
	{
		return recipeController.convertStringToDish(dish);
	}
	
	public void setKitchen(String k)
	{
		kitchen = k;
	}
	
	/* Returns the Kitchen object of the String kitchen variable using RecipeController. */
	public Kitchen getKitchen()
	{
		return recipeController.convertStringToKitchen(kitchen);
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
	
	/* Returns the Ingredients Array of the String ingredients Array using RecipeController. */
	public Ingredient[] getIngredients()
	{
		return recipeController.convertStringArrayToIngredientArray(ingredients);
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
	
}
