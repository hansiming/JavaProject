package offer005;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/** 
 * @Title: Main.java
 * @Package: offer005
 * @Description 倒序输出链表 堆栈实现
 * @author Han
 * @date 2016-4-15 上午11:08:08 
 * @version V1.0
 */ 

public class Main {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()){
			
			int count = scanner.nextInt();
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i = 0; i < count; i++){
				
				list.add(scanner.nextInt());
			}
			
			Iterator<Integer> iterator = list.iterator();
			
			while(iterator.hasNext()){
				
				stack.push(iterator.next());
			}
			
			while(!stack.isEmpty()){
				
				System.out.println(stack.pop());
			}
		}
	}
}
