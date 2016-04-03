package com.csdhsm.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
 * @Title: Test001.java
 * @Package: com.csdhsm.Algorithm
 * @Description 
 * @author Han
 * @date 2016-4-3 下午9:41:41 
 * @version V1.0
 */ 
  	
/**************************************************************************************************** 
题目：输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。 
要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。 
例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。 
输入：
每个测试案例包括两行：
第一行包含一个整数n和k，n表示数组中的元素个数，k表示两数之和。其中1 <= n <= 10^6，k为int
第二行包含n个整数，每个数组均为int类型。
输出：
对应每个测试案例，输出两个数，小的先输出。如果找不到，则输出“-1 -1”
样例输入：
6 15
1 2 4 7 11 15
*****************************************************************************************************/  

public class Test001 {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n;//数组中的元素个数
		int k;//表示两数之和
		
		System.out.println("请输入数组的个数");
		
		if(scanner.hasNextInt()){
			
			n = scanner.nextInt();
			if(n<=0){
				
				System.out.println("数组个数必须大于0");
				return;
			}
		}else{
			
			System.out.println("请输入一个整数");
			return;
		}
		
		System.out.println("请输入两数之和");
		
		if(scanner.hasNextInt()){
			
			k = scanner.nextInt();
		}else{
			
			System.out.println("请输入一个整数");
			return;
		}
		
		System.out.println("请输入" + n + "个升序数字");
		
		List<Integer> list = new ArrayList<Integer>();  
		
		for(int i=0;i<n;i++){
			
			System.out.println("请输入第" + (i+1) + "个数字");
			if(scanner.hasNextInt()){
				
				int temp = scanner.nextInt();
				
				if(i!=0){
					if(temp < list.get(i-1)){
						
						System.out.println("请输入升序数组");
					}else{
						
						System.out.println("输入成功");
						list.add(temp);
					}
				}else{

					System.out.println("输入成功");
					list.add(temp);
				}
			}else{
				
				System.out.println("输入错误,请重新输入!");
				i--;
			}
		}
		
		System.out.println(getTheTwoNumber(list,n,k));
	}

	 
	/** 
	 * @Description 得到相加为k的两个数字
	 * @author Han
	 * @param list 输入的数组
	 * @param n 数组个数
	 * @param k  相加之和
	 */
	  	
	private static List<Integer> getTheTwoNumber(List<Integer> list, int n, int k) {
		
		int low = 0;
		int high = n-1;
		
		List<Integer> result = new ArrayList<Integer>();
		
		while(low < high){
			
			if((list.get(low) + list.get(high)) == k){
				
				result.add(list.get(low));
				result.add(list.get(high));
				
				return result;
			}
			
			if((list.get(low) + list.get(high))<k){
				
				low ++;
			}else{
				
				high --;
			}
		}
		
		result.add(-1);
		result.add(-1);
		return result;
	}
}
