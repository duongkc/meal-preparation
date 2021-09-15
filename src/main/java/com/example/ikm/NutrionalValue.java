package com.example.ikm;

/**
 * Class to
 *
 * @author Kim Chau Duong
 * @version 1.0
 */
public class NutrionalValue {
    Double calories;
    Double fat;
    Double carbohydrates;
    Double protein;

    public NutrionalValue(String calories, String fat, String carbohydrates, String protein) {
        this.calories = Double.parseDouble(calories);
        this.fat = Double.parseDouble(fat);
        this.carbohydrates = Double.parseDouble(carbohydrates);
        this.protein = Double.parseDouble(protein);
    }

    public NutrionalValue(Double calories, Double fat, Double carbohydrates, Double protein) {
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getFat() {
        return fat;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public Double getProtein() {
        return protein;
    }
}
