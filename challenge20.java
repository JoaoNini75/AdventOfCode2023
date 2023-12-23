import java.io.File;
import java.util.Scanner;

public class challenge20 {
	
	private static final int IN_SIZE = 58;
	
	public static void main(String[] args) throws Exception {
		File myObj = new File("C:\\Users\\CASA\\eclipse-workspace\\AdventOfCode2023-pt2\\src\\input20.txt");
		Scanner in = new Scanner(myObj);
		int inNum = 0;
		
		int result = 0;
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			System.out.println(line);
			
			inNum++;
		}
		
		in.close();
		System.out.println("\ninput done\n");
		//System.exit(0);
		
		System.out.println(result);
	}

	/*				initial		recv low	recv high	prefix
	 * flip-flop	  off 		 invert		  null		  %
	 * conjunction  1 input -> inverts									  &
	 * broadcast	sends received to destinations
	 * button		sends low pulse to broadcast
	 */
}
