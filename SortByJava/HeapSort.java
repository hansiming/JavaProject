package com.csdhsm.sort;

/** 
 * @Title: HeapSort.java
 * @Package: com.csdhsm.sort
 * @Description 堆排序
 * @author Han
 * @date 2016-4-3 下午3:55:18 
 * @version V1.0
 */ 
  	
public class HeapSort {
	 
	/** 
	 * @Description 调整堆
	 * @author Han
	 * @param arr
	 * @param i
	 * @param size  
	 */
	  	
	private void heapAdjust(int[] arr,int i,int size){
		
		int lchild = i*2+1;//i节点的左子节点
		int rchild = i*2+2;//i节点的右子节点
		
		/**
		 * 右子节点大于左子节点
		 */
		if(rchild < size && arr[rchild] > arr[lchild]){
			
			swap(arr,lchild,rchild);
		}
		
		/**
		 * 左子节点大于根节点
		 */
		if(lchild < size && arr[lchild] > arr[i]){
			
			swap(arr,lchild,i);
		}
	}
	
	/** 
	 * @Description 建立堆
	 * @author Han  
	 */
	  	
	private void buildHeap(int[] arr,int size){
		
		int i = 0;
		//依次调整各个堆
		for(i = size/2;i>=1;i--){
			
			heapAdjust(arr,i-1,size);
		}
	}
	
	public void sort(int[] arr,int len){
		
		buildHeap(arr,len);
		for(int i = len-1 ; i>=1;i--){
			
			//将有序堆中的第一个元素和最后一个元素交换，取出最后一个元素
			swap(arr,0,i);
			//将无序堆重新构造为有许多
			buildHeap(arr,i);
		}
	}
	 
	/** 
	 * @Description 自定义交换方法
	 * @author Han
	 * @param arr
	 * @param firstIndex
	 * @param secondIndex  
	 */
	  	
	private void swap(int arr[],int firstIndex,int secondIndex){
		
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
}












