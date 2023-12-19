import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class challenge19 {

	private static final char ACCEPTED = 'A', REJECTED = 'R';
	private static final int WORKFLOW_NUM = 520, PART_NUM = 200;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// key: workflow name, value: list of rules
		Map<String, String[]> workflows = new HashMap<>(WORKFLOW_NUM);
		int[][] parts = new int[PART_NUM][4]; 
		
		File myObj = new File("C:\\Users\\CASA\\eclipse-workspace\\AdventOfCode2023-pt2\\src\\input19.txt");
		Scanner in = new Scanner(myObj);
		int inNum = 0;
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			
			if (inNum < 521) {
				String[] lineParts = line.split("{");
				String name = lineParts[0];
				String[] rules = lineParts[1].split(",");
				workflows.put(name, rules);
			} else if (inNum > 521) {
				
			}
			
			inNum++;
		}
		
		in.close();

		
	
		int result = 0;
		
		for (int i = 0; i < PART_NUM; i++) {
			int[] part = parts[i];
			if (isAccepted(part))
				result += part[0] + part[1] + part[2] + part[3];
		}
		
		System.out.println(result);
	}

	private static boolean isAccepted(int[] part) {
		// TODO Auto-generated method stub
		return false;
	}
}
