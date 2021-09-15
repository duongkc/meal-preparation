package com.example.ikm;

import com.google.gson.Gson;
/**
 * Class to
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class NutrientReader extends FileReader {

    private Nutrition[] nutritionArray;

    public NutrientReader() {
        filePath = "data/nutrients.json";
        fileText = getJsonAsString(filePath);

        readJson();
    }

    public Nutrition[] getNutritions(){ return nutritionArray; }

    @Override
    public void readJson()
    {
        Gson gson = new Gson();
        nutritionArray = gson.fromJson(fileText, Nutrition[].class);
    }

//    Also a test method that can be ignored
    void testing(){
        Nutrition n = nutritionArray[1];
        System.out.println(n.getItemId());
        System.out.println(n);
    }
}
