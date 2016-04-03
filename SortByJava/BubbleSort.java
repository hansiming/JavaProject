package com.csdhsm.sort;

/** 
 * @Title: BubbleSort.java
 * @Package: com.csdhsm.sort
 * @Description 冒泡排序 
 * @author Han
 * @date 2016-4-3 上午11:27:50 
 * @version V1.0
 */ 
  	
public class BubbleSort {
	
	public void sort(int[] arr,int len){
		
		for(int i = 0;i<len-1;i++){
			
			for(int j = 1;j<len-i;j++){
				
				if(arr[j-1] > arr[j]){
					
					int k = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = k;
				}
			}
		}
	}
}
