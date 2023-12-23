package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class challenge9 {
	
	public static void main(String[] args) {
			
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input9.txt");
			Scanner reader = new Scanner(myObj);
			
			int[][] input = new int[200][21];
			int in = 0;
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine().trim();
				String[] strs = line.split(" ");
				int[] res = new int[21];
				for (int i = 0; i < strs.length; i++)
					res[i] = Integer.parseInt(strs[i]);
				input[in++] = res;
			}
				
			reader.close();
			int result = 0;
			
			for (int i = 0; i < input.length; i++) {
				int[] history = input[i];
				List<int[]> list = new ArrayList<>();
				list.add(history);
				
				int[] next = history;
				
				while (true) {
					CH9_Sequence seq = generateSequence(next);
					list.add(seq.getSequence());
					next = seq.getSequence();
					if (seq.isAllZeros())
						break;
				}
				
				int[] newValues = new int[list.size()];
				
				for (int j = list.size()-2; j >= 0; j--) {
					int valBefore = newValues[j+1];
					int seqFirst = list.get(j)[0];
					newValues[j] = seqFirst - valBefore;
				}
				
				/* PART1
				for (int j = list.size()-2; j >= 0; j--) {
					int[] seq = list.get(j);
					newValues[j] = seq[seq.length-1] + newValues[j+1];
				}*/
				
				int res = newValues[0];
				result += res;
				System.out.println("res: " + res + "   result: " + result);
			}
			
			System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static CH9_Sequence generateSequence(int[] seq) {
		boolean allZeros = true;
		int[] newSeq = new int[seq.length-1];
		
		for (int i = 0; i < seq.length-1; i++) {
			int step = seq[i+1] - seq[i];
			newSeq[i] = step;
			if (step != 0)
				allZeros = false;
		}
		
		return new CH9_Sequence(newSeq, allZeros);
	}
}
