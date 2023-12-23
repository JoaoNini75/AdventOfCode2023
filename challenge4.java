package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class challenge4 {

	public static void main(String[] args) {
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input4.txt");
			Scanner myReader = new Scanner(myObj);
			int i = 1;
			
			int[] cardsToProcess = new int[199]; // card[1] -> carta 1
			
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String nums = line.split(": ")[1];
				
				String winNumsStr = nums.substring(0, 29);
				String myNumsStr = nums.substring(32);
				
				String[] winNums = winNumsStr.split(" ");
				String[] myNums = myNumsStr.split(" ");
				
				int matches = 0;
				
				for (int j = 0; j < winNums.length; j++) {
					for (int k = 0; k < myNums.length; k++) {
						if (winNums[j].equals(myNums[k]) && !winNums[j].trim().equals("")) {
							matches++;	
							//System.out.println("match: " + winNums[j] + "  matches: " + matches);
							break;
						}
					}
				}	
				
				for (int p = 0; p < cardsToProcess[i]+1; p++)
					for (int card = i+1; card < i+1+matches; card++)
						cardsToProcess[card]++;
				
				//System.out.println("result: " + result + "\n");
				//if (i == 4) break;
				i++;
			}
			
			myReader.close();
			int result = 198;
			
			for (int j = 2; j < cardsToProcess.length; j++)
				result += cardsToProcess[j];
			
			System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	private static int part1(Scanner myReader) {
		int result = 0;
		int i = 0;
		
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			String nums = line.split(": ")[1];
			
			String winNumsStr = nums.substring(0, 29);
			String myNumsStr = nums.substring(32);
			
			String[] winNums = winNumsStr.split(" ");
			String[] myNums = myNumsStr.split(" ");
			
			int res = 0;
			
			System.out.println(nums);
			
			// TODO: processar num de matches para cada card ; depois multiplicar 
			
			for (int j = 0; j < winNums.length; j++) {
				for (int k = 0; k < myNums.length; k++) {
					if (winNums[j].equals(myNums[k]) && !winNums[j].trim().equals("")) {
						if (res == 0)
							res = 1;
						else
							res *= 2;
						
						System.out.println("match: " + winNums[j] + "  res: " + res);
						
						break;
					}
				}
			}	
			
			result += res;
			
			System.out.println("result: " + result + "\n");
			//if (i == 4) break;
			i++;
		}
		
		myReader.close();
		return result;
	}

}
