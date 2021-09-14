package com.example.ikm;

public class Person 
{
	boolean vegetarian;
	Allergy[] allergies;
	Recipe[] favourite = new Recipe[0];
	
	void addFavourite(Recipe recipe) {
		Recipe[] favouritesNew = new Recipe[this.favourite.length + 1];
		for (int i = 0; i < this.favourite.length; i++) {
			favouritesNew[i] = favourite[i];
		}
		favouritesNew[this.favourite.length] = recipe;
		this.favourite = favouritesNew;
		
	}
}
