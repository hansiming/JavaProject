package com.cszjo.design.patterns.builder;

/**
 * Created by hansiming on 2017/10/23.
 */
public class NutritionFacts {

    private final int seringSize;
    private final int servings;
    private final int calories;

    public static class Builder {

        private int seringSize;
        private int servings;
        private int calories = 0;

        public Builder(int seringSize, int servings) {
            this.seringSize = seringSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    public NutritionFacts(Builder builder) {
        this.seringSize = builder.seringSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "seringSize=" + seringSize +
                ", servings=" + servings +
                ", calories=" + calories +
                '}';
    }
}
