package com.cszjo.data.structure.graph;

import java.util.Scanner;

public class Floyd {

    private static final int MAX = 1000000;

    private void floyd(int[][] matrix) {
        int[][] path = new int[matrix.length][matrix.length];

        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                if (matrix[i][j] != MAX) {
                    path[i][j] = i;
                } else {
                    path[i][j] = j;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (matrix[j][k] > matrix[j][i] + matrix[i][k]) {
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                        path[j][k] = i;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    continue;
                }
                if (matrix[i][j] == MAX) {
                    System.out.println(String.format("%s -> %s 不可达", i, j));
                    continue;
                }

                String res = findPath(path, i, j) + " -> " + j;
                System.out.println(String.format(
                        "%s -> %s 最短路径为 %s , 分别经过 %s", i, j,
                        matrix[i][j], res));
            }
        }
    }

    private String findPath(int[][] path, int i, int j) {
        if (path[i][j] == i) {
            return String.valueOf(i);
        }

        return findPath(path, i, path[i][j]) + " -> " + path[i][j];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertexCount = Integer.parseInt(scanner.nextLine());

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

        new Floyd().floyd(matrix);
    }
}
