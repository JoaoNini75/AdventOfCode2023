package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class challenge8 {
	
	public static void main(String[] args) {
			
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input8.txt");
			Scanner reader = new Scanner(myObj);
			
			String lr = "";
			String[][] matrix = new String[742][3];
			
			int in = 1;
			int result = 0;
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine().trim();
				
				if (in == 1)
					lr = line;
				else if (in == 2) {
					
				} else {
					String[] parts = line.split("=");
					String[] leftRight = parts[1].split(", ");
					matrix[in-3] = new String[] { parts[0].trim(), leftRight[0].substring(2), leftRight[1].substring(0, 3) }; 
				}
				
				in++;
			}
				
			reader.close();
			System.out.println(lr.length());
				
			for (int i = 0; i < matrix.length; i++) {
				
				
				for (int j = 0; j < matrix[i].length; j++) {
					//System.out.println(matrix[i][j]);
				}
			}
			
			
			System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

