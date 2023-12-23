package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import adventOfCode2023.CH7_Hand.HandComparator;

public class challenge7 {
	
	private static final int INPUT_SIZE = 1000;

	public static void main(String[] args) {
		
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input7.txt");
			Scanner reader = new Scanner(myObj);
			
			//String[] hands = new String[1000]; //int[] bids = new int[1000];
			
			List<CH7_Hand> list = new ArrayList<>(INPUT_SIZE);
			//int in = 0;
			int result = 0;
			
			while (reader.hasNextLine()) {
				String[] ins = reader.nextLine().trim().split(" ");
				//hands[in] = ins[0];//bids[in] = Integer.parseInt(ins[1]);//in++;
				list.add(new CH7_Hand(ins[0], Integer.parseInt(ins[1])));
			}
				
			reader.close();
			Collections.sort(list, new HandComparator());
			
			for (int i = 0; i < list.size(); i++) {
				CH7_Hand h = list.get(i);
				System.out.println(h.getHand());
				int res = h.getBid() * (i+1);
				result += res;
				String r = String.valueOf(i+1), resStr = String.valueOf(res);
				System.out.println("bid: " + h.getBid() + "  rank: " + r + "  res: " + resStr + "  result: " + result + "\n");
			}
				
			
			System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
}
