package com.csdhsm.sort;

public class MergeSort {
	
	public void sort(int[] arr,int low,int high){
		
		int mid = (low + high)/2;
		if(low < high){
			
			sort(arr,low,mid);
			sort(arr,mid+1,high);
			mergeSort(arr,low,mid,high);
		}
	}
	
	private void mergeSort(int[] arr,int low,int mid,int high){
		
		/**
		 * 用于存放归并好的数组 
		 */
		int[] copyArr = new int[high - low + 1];
		
		int i = low;
		int j = mid + 1;
		int k = 0;
		
		/**
		 * 比较两个有序序列
		 */
		while(i<=mid&&j<=high){
			
			if(arr[i] <= arr[j]){
				
				copyArr[k] = arr[i];
				i++;
			}else{
				
				copyArr[k] = arr[j];
				j++;
			}
			
			k++;
		}
		
		/**
		 * 下面两个循环只会执行一个
		 */
		while(i<=mid){
			
			copyArr[k] = arr[i];
			i++;
		}
		
		while(j<=high){
			
			copyArr[k] = arr[j];
			j++;
		}
		
		for(i=0;i<=k;i++){
			
			arr[low+i] = copyArr[i];
		}
	}
}
