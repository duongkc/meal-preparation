package com.example.ikm;

public class Dish 
{
	private String name;
	
	public Dish() 
	{
		name = "";
	}
	public Dish(String name) 
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
}
