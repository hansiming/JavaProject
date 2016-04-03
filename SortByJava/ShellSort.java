package com.csdhsm.sort;

/** 
 * @Title: ShellSort.java
 * @Package: com.csdhsm.sort
 * @Description 希尔排序
 * @author Han
 * @date 2016-4-3 下午5:04:01 
 * @version V1.0
 */ 
  	
public class ShellSort {
	
	public void sort(int[] arr,int len){
		
		/**
		 * 步长默认为长度/2
		 */
		int gap = len/2;
		
		/**
		 * 当步长gap为1时,结束排序
		 */
		while(gap >= 1){
			
			// 把距离为 gap 的元素编为一个组，扫描所有组
			for(int i = gap;i < len;i ++){
				
				int temp = arr[i];
				int j = 0;
				
				// 对距离为 gap 的元素组进行排序
				for(j = i-gap;j >= 0 && temp < arr[j];j = j-gap){
					
						arr[i] = arr[j];
				}
				arr[j + gap] = temp;
			}
			//减小增量
			gap = gap / 2;
		}
	}
}







