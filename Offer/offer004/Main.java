package offer004;

import java.util.Scanner;

/** 
 * @Title: Main.java
 * @Package: offer004
 * @Description 替换空格
 * @author Han
 * @date 2016-4-14 上午8:52:14 
 * @version V1.0
 */ 
  	
public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
		char[] inputArr = null;
		
		while(scanner.hasNextLine()){
			
			input = scanner.nextLine();
			inputArr = input.toCharArray();
			String str = new String(findTheBlank(inputArr));
			System.out.println(str);
		}
	}

	private static char[] findTheBlank(char[] inputArr) {
		
		int blankCount = 0;
		
		if(inputArr == null){
			
			throw new NullPointerException("空指针异常！");
		}
		
		for(int i = 0; i < inputArr.length; i++){
			
			if(inputArr[i] == ' '){
				
				blankCount++;
			}
		}
		
		char[] newArr = new char[inputArr.length + (blankCount*2)];
		
		for(int i = (inputArr.length-1); i >= 0; i--){
			
			if(inputArr[i] == ' '){
				
				newArr[i + (blankCount*2)] = '0';
				newArr[i + (blankCount*2-1)] = '2';
				newArr[i + (blankCount*2-2)] = '%';
				blankCount--;
			}else{
				
				newArr[i + (blankCount*2)] = inputArr[i];
			}
		}
		
		return newArr;
	}
}
