package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class challenge11 {
	
	public static void main(String[] args) {
			
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input11.txt");
			Scanner reader = new Scanner(myObj);
			
			char[][] input = new char[140][140];
			int in = 0;
			List<Integer> linesToAdd = new ArrayList<>();
			
			while (reader.hasNextLine()) {
				char[] line = reader.nextLine().trim().toCharArray();
				if (isAllDots(line))
					linesToAdd.add(in+1);
				input[in++] = line;
			}
				
			reader.close();
			
			// TODO steps: read, expansion, save galaxies coordinates,
			// iterate over that list and calculate distance to all 
			// the following galaxies, suming each iteration
			
			// expansion - lines
			int lineNum = 140 + linesToAdd.size();
			char[][] linesExp = new char[lineNum][140];
			int inCounter = 0;
			
			for (int i = 0; i < lineNum; i++) {
				int idx = -1; 
				if (linesToAdd.size() > 0)
					linesToAdd.get(0);
				
				if (idx == i) {
					linesExp[i] = allDots();
					linesToAdd.remove(0);
				} else {
					linesExp[i] = input[inCounter++];
				}
			}
			
			List<Integer> colsToAdd = new ArrayList<>();
			
			for (int i = 0; i < linesExp.length; i++) {
				char[] col = new char[linesExp.length];
				
				for (int j = 0; j < linesExp[i].length; j++) 
					col[j] = linesExp[i][j];
				
				if (isAllDots(col))
					colsToAdd.add(i+1);
			}
			
			// expansion - columns TODO NOT WORKING
			int colNum = 140 + colsToAdd.size();
			char[][] m = new char[lineNum][colNum];
			int lExpCounter = 0;
			
			for (int i = 0; i < lineNum; i++) {
				int idx = -1; 
				if (colsToAdd.size() > 0)
					colsToAdd.get(0);
				
				if (idx == i) {
					m[i] = allDots();
					colsToAdd.remove(0);
				} else {
					m[i] = linesExp[lExpCounter++];
				}
			}
				
			List<CH11_Pair> galaxies = new ArrayList<>();
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if (m[i][j] == '#')
						galaxies.add(new CH11_Pair(i, j));
				}
			}	
			
			int result = 0;
			
			for (int i = 0; i < galaxies.size(); i++) {
				CH11_Pair galaxy = galaxies.get(i);
				
				for (int j = i+1; j < galaxies.size(); j++) {
					CH11_Pair g = galaxies.get(j);
					int res = shortestPath(galaxy.getX(), galaxy.getY(), g.getX(), g.getY());
					result += res;
				}
			}
			
			System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static int shortestPath(int xSrc, int ySrc, int xDest, int yDest) {
		return Math.abs(xSrc-xDest) + Math.abs(ySrc-yDest);
	}

	private static char[] allDots() {
		char[] dots = new char[140];
		for (int i = 0; i < 140; i++)
			dots[i] = '.';
		return dots;
	}

	private static boolean isAllDots(char[] list) {
		for (char c : list)
			if (c != '.')
				return false;
		
		return true;
	}
}
