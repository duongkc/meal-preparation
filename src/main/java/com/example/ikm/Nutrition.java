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
}
