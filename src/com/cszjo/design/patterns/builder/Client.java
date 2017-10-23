package com.cszjo.design.patterns.builder;

/**
 * Created by hansiming on 2017/10/23.
 */
public class Client {

    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts.Builder(1, 2).calories(3).build();
        System.out.println(facts);
    }
}
