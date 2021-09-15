package com.example.ikm;

public class Ingredient 
{
	private String name;
	private String type;
	
	public Ingredient() 
	{
		name = "";
	}
	
	public Ingredient(String name) 
	{
		this.name = name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public String getType() 
	{
		return type;
	}
}
