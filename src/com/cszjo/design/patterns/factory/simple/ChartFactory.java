package com.cszjo.design.patterns.factory.simple;

/**
 * Created by hansiming on 2017/10/16.
 */
public class ChartFactory {

    public static Chart getChartByType(String type) {
        if (type.equals("round")) {
            return new RoundChart();
        } else if (type.equals("square")) {
            return new SquareChart();
        }
        return null;
    }

    public static void main(String[] args) {
        Chart chart = ChartFactory.getChartByType("round");
        chart.disPlay();
    }
}
