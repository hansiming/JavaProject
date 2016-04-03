package com.csdhsm.sort;

/** 
 * @Title: SelectSort.java
 * @Package: com.csdhsm.sort
 * @Description 选择排序
 * @author Han
 * @date 2016-4-3 下午3:44:33 
 * @version V1.0
 */ 
  	
public class SelectSort {
	
	public void sort(int[] arr,int len){

		
		for(int i=0;i<len-1;i++){
			
			//记录最小元素的下标
			int min = i;
			
			for(int j=i+1;j<len;j++){
				
				if(arr[j] < arr[min]){
					
					min = j;
				}
			}
			/**
			 * 将最小值交换至前端
			 */
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
