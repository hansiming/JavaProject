package off003;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()){
			
			String temp = scanner.nextLine();
			temp = temp.replaceAll(" ", "%20");
			System.out.println(temp);
		}
	}
}	
