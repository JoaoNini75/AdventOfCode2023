package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class challenge2 {
	
	final static int MAX_RED = 12, MAX_GREEN = 13, MAX_BLUE = 14;

	public static void main(String[] args) {
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input2.txt");
			Scanner myReader = new Scanner(myObj);
			int result = 0;
			
			int i = 1;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] sepByTwoDots = line.split(":");
				String id = sepByTwoDots[0].split(" ")[1];
				String[] sets = sepByTwoDots[1].split(";");
				
				
				
				//System.out.println("line: " + id);
				//for (int j = 0; j < sets.length; j++)
					//System.out.println(sets[j]);
				
				
				/*if (isPossible(sets))
					result += Integer.parseInt(id);*/
				int res = getGameRes(sets);
				result += res;
				System.out.println(line + " " + res);
				
				//if (i == 4) break;
				i++;
			}
			
			myReader.close();
			System.out.println(result);
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static int getGameRes(String[] sets) {
		int red = 0, green = 0, blue = 0;
		
		for (int i = 0; i < sets.length; i++) {
			String set = sets[i].substring(1).trim();
			//System.out.println(set);
			String[] pairs = set.split(", ");

			for (int j = 0; j < pairs.length; j++) {
				String pair = pairs[j];
				//System.out.println(pair);
				
				String[] numColor = pair.split(" ");
				int number = Integer.parseInt(numColor[0]);
				String color = numColor[1];
				//System.out.println("color: " + color + " number: " + number);
				
				
				if (color.equals("red") && number > red)
					red = number;
				else if (color.equals("green") && number > green)
					green = number;
				else if (color.equals("blue") && number > blue)
					blue = number;
			}
			//System.out.println();
		}
			
		return red * green * blue;
	}
	
	private static boolean isPossible(String[] sets) {
		for (int i = 0; i < sets.length; i++) {
			String set = sets[i].substring(1).trim();
			//System.out.println(set);
			String[] pairs = set.split(", ");

			for (int j = 0; j < pairs.length; j++) {
				String pair = pairs[j];
				//System.out.println(pair);
				
				String[] numColor = pair.split(" ");
				int number = Integer.parseInt(numColor[0]);
				String color = numColor[1];
				//System.out.println("color: " + color + " number: " + number);
				
				
				if ((color.equals("red") && number > MAX_RED) || (color.equals("green") && number > MAX_GREEN) || (color.equals("blue") && number > MAX_BLUE))
					return false;
			}
			//System.out.println();
		}
			
		return true;
	}
	
}
