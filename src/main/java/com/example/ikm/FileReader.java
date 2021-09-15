package com.example.ikm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import com.google.gson.Gson;

public class FileReader 
{
	private String filePath;
	private String fileText;
	private Recipe[] recipeArray;
	
	public FileReader()
	{
		filePath = "C:\\Users\\imke_\\Documents\\IT-traineeship\\EclipseWorkspace\\meal-preparation\\recipe.json";
		fileText = getJsonAsString(filePath);
		
		readJson();
	}
	
	public static String getJsonAsString(String filePath)
	{
		StringBuilder contentBuilder = new StringBuilder();
		try  
		{
			Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8);
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
			stream.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
 
		return contentBuilder.toString();
	}
	
	public void readJson()
	{
		Gson gson = new Gson();
		recipeArray = gson.fromJson(fileText, Recipe[].class);
	}
	
	public Recipe[] getRecipes()
	{
		return recipeArray;
	}
}
