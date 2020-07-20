package com.cszjo.leetcode.array;

import java.util.HashMap;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) return 0;

        UnionFind uf = new UnionFind(nums);

        for(int i=0;i<nums.length;i++){
            //查找当前节点的上一个节点
            if(uf.fatherMap.containsKey(nums[i]-1)){
                uf.union(nums[i]-1,nums[i]);
            }
        }
        return uf.max;
    }
    public class UnionFind{
        int max = 1;
        HashMap<Integer,Integer> fatherMap;
        HashMap<Integer,Integer> sizeMap;

        public UnionFind(int[] nums){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for(int val: nums){
                fatherMap.put(val,val);
                sizeMap.put(val,1);
            }
        }

        //找到父节点并优化结构
        public int findFather(int val){
            int father = fatherMap.get(val);
            if(father != val){
                father = findFather(father);
            }
            fatherMap.put(val,father);
            return father;
        }

        public void union(int a,int b){
            int aFather = findFather(a);
            int bFather = findFather(b);
            if(aFather != bFather){
                int  aFatherSize = sizeMap.get(aFather);
                int  bFatherSize = sizeMap.get(bFather);

                fatherMap.put(aFather,bFather);
                sizeMap.put(bFather,aFatherSize + bFatherSize);

                max = Math.max(max,aFatherSize + bFatherSize);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        new Solution128().longestConsecutive(nums);
    }
}
