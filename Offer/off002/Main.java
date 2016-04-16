package off002;

/**
 * @Title: Main.java
 * @Package: off002
 * @Description 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 *              每一列都按照从上到下递增的顺序排序。请完成一个函数，
 *              输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 * @author Han
 * @date 2016-4-13 下午5:17:34 
 * @version V1.0
 */
public class Main {
	
	public static void main(String[] args) {
		
		//for a example
		//rows = 3,column = 3,number = 2
		//arr 1 2 3
		//    4 5 6
		//    7 8 9
		//return true
		int[] arr = {3,3,0,1,2,3,4,5,6,7,8,9};
		int rows = arr[0];
		int columns = arr[1];
		int number = arr[2];
		
		if(find(arr, rows, columns, number)){
			
			System.out.println(true);
		}else{
			
			System.out.println(false);
		}
	}

	private static boolean find(int arr[], int rows, int columns, int number) {
		
		//find the lower left quarter first
		int row = rows - 1;
		int column = 0;
		
		//row < 0 and column = columns over the while and return false
		while(row >= 0 && column < columns){
			
			//find the number
			if(arr[row * columns + column] == number){
				
				return true;
			}else if(arr[row * columns + column] < number){
				
				column++;
			}else{
				
				row--;
			}
		}
		
		return false;
	}
}
