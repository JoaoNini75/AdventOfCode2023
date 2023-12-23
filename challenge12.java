import java.io.File;
import java.util.Scanner;

public class challenge12 {
	
	private static final int IN_SIZE = 1000;
	//private static final char NIL = '\u0000';
	
	public static void main(String[] args) throws Exception {
		File myObj = new File("C:\\Users\\CASA\\eclipse-workspace\\AdventOfCode2023-pt2\\src\\input12.txt");
		Scanner in = new Scanner(myObj);
		int inNum = 0;
		
		String[] records = new String[IN_SIZE];
		String[] conditions = new String[IN_SIZE];
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			System.out.println(line);
			
			String[] parts = line.split(" ");
			records[inNum] = parts[0];
			conditions[inNum] = parts[1];
			
			inNum++;
		}
		
		in.close();
		System.out.println("\ninput done\n");
		//System.exit(0);
	
		int result = 0;
		
		for (int i = 0; i < IN_SIZE; i++) {
			String record = records[i];
			String condition = conditions[i];
			int res = arrangements(record, condition);
			result += res;
		}
		
		System.out.println(result);
	}
	
	private static int arrangements(String record, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
