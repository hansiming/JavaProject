package com.csdhsm.sort;

/** 
 * @Title: InsertSort.java
 * @Package: com.csdhsm.sort
 * @Description 插入排序
 * @author Han
 * @date 2016-4-3 上午9:41:01 
 * @version V1.0
 */ 
  	
public class InsertSort {
	
	 
	/** 
	 * @Description 插入排序 1
	 * @author Han
	 * @param arr
	 * @param len  
	 */
	  	
	public void sort1(int[] arr,int len){
		
		//从第一个位置开始插入排序
		for(int i = 1;i < len;i ++){
			
			int k = arr[i];
			//如果该位置比上一个位置大，那么则不需要进行插入排序
			if( k < arr[i-1]){
				
				int count = 0;
				while(i > 0&&k < arr[i-1]){
					
					arr[i] = arr[i-1];
					arr[i-1] = k;
					i--;
					count++;
				}
				i += count;
			}
		}
	}
	
	 
	/** 
	 * @Description 插入排序2
	 * @author Han
	 * @param arr
	 * @param len  
	 */
	  	
	public void sort2(int[] arr,int len){
		
		for(int i = 1;i<len;i++){
			
			if(arr[i] < arr[i-1]){
				
				int k = arr[i];
				int j=i-1;
				/**
				 * 依次去寻找插入的位置
				 */
				for(;j>=0&&arr[j] > k;j--){
					
					arr[j+1] = arr[j];
				}
				arr[j+1] = k;
			}
		}
	}	
}
