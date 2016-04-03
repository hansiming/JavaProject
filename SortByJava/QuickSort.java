package com.csdhsm.sort;

/** 
 * @Title: QuickSort.java
 * @Package: com.csdhsm.sort
 * @Description 快速排序
 * @author Han
 * @date 2016-4-3 上午11:37:02 
 * @version V1.0
 */ 
  	
public class QuickSort {
	
	/**
	 * 快速排序递归调用
	 * @Description 
	 * @author Han
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void sort(int[] arr,int low,int high){
		
		if(low < high){
			
			int pos = findPoss(arr,low,high);
			sort(arr,low,pos-1);
			sort(arr,pos+1,high);
		}
	}
	
	 
	/** 
	 * @Description 寻找合适的位置
	 * @author Han
	 * @param a
	 * @param low
	 * @param high  
	 */
	  	
	public int findPoss(int arr[],int low,int high){
		
		/**
		 * t为锚点，左边都是小于t的数字，右边都是大于t的数字
		 */
		int t = arr[low];
		
		/**
		 * 一直要找到low等于high为止
		 */
		while(low < high){
			
			while(low < high && arr[high] >= t){
				
				high--;
			}
			arr[low] = arr[high];
			
			while(low <high && arr[low] <= t){
				
				low++;
			}
			arr[high] = arr[low];
		}
		
		arr[low] = t;
		return low;
	}
}
