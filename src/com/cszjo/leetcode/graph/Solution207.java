package com.cszjo.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        if (q.isEmpty()) {
            return false;
        }

        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            numCourses--;
            List<Integer> edges = adj.get(vertex);
            for (int i = 0; i < edges.size(); i++) {
                if (--indegree[edges.get(i)] == 0) {
                    q.offer(edges.get(i));
                }
            }
        }

        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] num = {{0,1}};
        new Solution207().canFinish(2, num);
    }
}
