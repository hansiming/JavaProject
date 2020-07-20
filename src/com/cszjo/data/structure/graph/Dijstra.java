package com.cszjo.data.structure.graph;

import java.util.Scanner;

public class Dijstra {

    private static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertexCount = Integer.parseInt(scanner.nextLine());
        int source = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                int weight = Integer.parseInt(scanner.nextLine());
                if (weight == 0) {
                    matrix[i][j] = MAX;
                } else {
                    matrix[i][j] = weight;
                }
            }
        }

        new Dijstra().dijstra(matrix, source);
    }

    private void dijstra(int[][] matrix, int source) {

        boolean[] visited = new boolean[matrix.length];

        int[] shortest = new int[matrix.length];

        visited[source] = true;
        shortest[source] = 0;

        for (int i = 1; i < matrix.length; i++) {

            int min = MAX;
            int inx = -1;

            for (int j = 0; j < matrix.length; j++) {
                if (!visited[j] && matrix[source][j] < min) {
                    min = matrix[source][j];
                    inx = j;
                }
            }

            visited[inx] = true;
            shortest[inx] = shortest[source] + matrix[source][inx];

            for (int j = 0; j < matrix.length; j++) {
                if (!visited[j] && matrix[inx][j] < MAX) {
                    matrix[source][j] = matrix[source][inx] + matrix[inx][j];
                }
            }
        }

        for (int i = 0; i < shortest.length; i++) {
            System.out.println(
                    String.format("vertex %s -> vertex %s shortest path is %s",
                                  source, i, shortest[i]));
        }
    }
}

// 迪杰斯特拉算法
// 所有权重都必须是非负的，因为迪杰斯塔拉算法是基于贪心算法，所以不能有负值，无法回退
//4
//0
//4
//0
//3
//0
//0
//5
//0
//0
//0
//0
//1
//0
//0
//0
//0