package com.example.ikm;

/**
 * Class to
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class Nutrition {
    int itemId;
    NutrionalValue nutrientsFull;
    NutrionalValue nutrientsSingle;

    public Nutrition(int itemId, NutrionalValue nutrientsFull, NutrionalValue nutrientsSingle) {
        this.itemId = itemId;
        this.nutrientsFull = nutrientsFull;
        this.nutrientsSingle = nutrientsSingle;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public NutrionalValue getNutrientsFull() {
        return nutrientsFull;
    }

    public void setNutrientsFull(NutrionalValue nutrientsFull) {
        this.nutrientsFull = nutrientsFull;
    }

    public NutrionalValue getNutrientsSingle() {
        return nutrientsSingle;
    }

    public void setNutrientsSingle(NutrionalValue nutrientsSingle) {
        this.nutrientsSingle = nutrientsSingle;
    }

    @Override
    public String toString(){
        String leftAlignFormat = "| %-18s | %-11s | %-11s |%n";

        return String.format("+--------------------+-------------+-------------+%n")
        + String.format("+ Nutrient           + Serving 1   + Serving All +%n")
        + String.format("+--------------------+-------------+-------------+%n")
        + String.format(leftAlignFormat, "Calories (kcal)", nutrientsSingle.getCalories(),
                nutrientsFull.getCalories())
        + String.format(leftAlignFormat, "Fat (g)", nutrientsSingle.getFat(),
                nutrientsFull.getFat())
        + String.format(leftAlignFormat, "Carbohydrates (g)", nutrientsSingle.getCarbohydrates(),
                nutrientsFull.getCarbohydrates())
        + String.format(leftAlignFormat, "Protein (g)", nutrientsSingle.getProtein(),
                nutrientsFull.getProtein())
        + String.format("+--------------------+-------------+-------------+%n");
    }
}
