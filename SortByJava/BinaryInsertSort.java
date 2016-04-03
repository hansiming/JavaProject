package com.csdhsm.sort;

/** 
 * @Title: BinaryInsertSort.java
 * @Package: com.csdhsm.sort
 * @Description 折半插入排序
 * @author Han
 * @date 2016-4-3 上午10:56:09 
 * @version V1.0
 */ 
  	
public class BinaryInsertSort {
	
	public void sort(int[] arr,int len){
		
		for(int i=1;i<len;i++){
			
			int low = 0;
			int high = i-1;
			
			int k = arr[i];
			
			//从mid开始查找应该插入的位置
			
			while(low <= high){
				
				//计算mid的位置
				int mid = (low + high)/2;
				if(arr[mid] < k){
					low ++;
				}else{
					high --;
				}
			}
			
			for(int j=i-1;j>=low;j--){
				
				arr[j+1] = arr[j];
			}
			arr[low] = k;
		}
	}
}
