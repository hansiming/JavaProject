package com.csdhsm.acm2;

public class Main {
	
	public static void main(String[] args) {
	
		for(int i = 1000; i < 9999; i++){
			
			//sum of 10
			int sum10 = 0;
			//sum of 12
			int sum12 = 0;
			//sum of 16
			int sum16 = 0;
			int k = 0;

			k = i;
			do{
				
				sum10 += (k%10);
				k /= 10;
			}while(k != 0);

			k = i;
			do{
				
				sum12 += (k%12);
				k /= 12;
			}while(k != 0);

			//sum of 10 and sum of 12 is not equal
			if(sum10 != sum12){
				
				continue;
			}

			k = i;
			do{
				
				sum16 += (k%16);
				k /= 16;
			}while(k != 0);
			
			if(sum10 == sum16){
				
				System.out.println(i);
			}
		}
	}
}
