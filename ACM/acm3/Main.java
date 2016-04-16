package com.csdhsm.acm3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Privance {

	public Map<String, String> privance;

	public Privance() {

		privance = new HashMap<String, String>();
		privance.put("330000", "Zhejiang");
		privance.put("110000", "Beijing");
		privance.put("710000", "Taiwan");
		privance.put("810000", "Hong Kong");
		privance.put("820000", "Macao");
		privance.put("210000", "Liaoning");
		privance.put("540000", "Tibet");
		privance.put("310000", "ShangHai");
	}
}

// out put He/She is from Zhejiang,and his/her birthday is on 10,12,1989 based
// on the table.
public class Main {

	public static void main(String[] args) {

		Privance privance = new Privance();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {

			int i = Integer.parseInt(scanner.nextLine());
			
			for(int j = 0; j < i; j++){
				
				String str = scanner.nextLine();
				// get privanceID like 330000
				String privanceStr = str.substring(0, 6);
				// get the privanceNae like Zhejiang
				privanceStr = privance.privance.get(privanceStr);
				String yearStr = str.substring(6, 10);
				String mouthStr = str.substring(10, 12);
				String dayStr = str.substring(12, 14);

				System.out.println("He/She is from " + privanceStr
						+ ",and his/her birthday is on " + mouthStr + "," + dayStr
						+ "," + yearStr + " based on the table.");
			}
		}
	}
}
