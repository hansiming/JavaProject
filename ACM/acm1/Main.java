package com.csdhsm.acm1;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int sum = 0,count = - 1,previous = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(count != 0){
			
			previous = 0;
			
			sum = 0;
			
			count = scanner.nextInt();
			
			for(int i = 0; i < count; i++){
				
				int temp = scanner.nextInt();
				int _sum =  calculate(previous,temp);
				sum += _sum;
				previous = temp;
			}
			
			if(count != 0){
				
				System.out.println(sum);
			}
		}
	}

	private static int calculate(int previous, int temp) {
		
		if(temp > previous){
			
			return (temp - previous)*6 + 5;
		}else if(temp < previous){
			
			return (previous - temp)*4 + 5;
		}else{
			
			return 5;
		}
	}
}
