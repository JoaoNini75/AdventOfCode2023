import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class challenge19 {

	private static final int WORKFLOW_NUM = 520, PART_NUM = 200;
	private static final Map<String, String[]> workflows = new HashMap<>(WORKFLOW_NUM);
	
	public static void main(String[] args) throws Exception {
		// key: workflow name, value: list of rules
		
		
		File myObj = new File("C:\\Users\\CASA\\eclipse-workspace\\AdventOfCode2023-pt2\\src\\input19.txt");
		Scanner in = new Scanner(myObj);
		int inNum = 1;
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim().replace('{', '_');
			line = line.substring(0, line.length()-1);
			//System.out.println(line);
			if (inNum >= 521)
				break;
			
			String[] lineParts = line.split("_");
			String name = lineParts[0];
			String[] rules = lineParts[1].split(",");
			workflows.put(name, rules);

			inNum++;
		}
		
		in.close();
		System.out.println("\n input done \n");
		//System.exit(0);
	
		final String[] IN_WORKFLOW = workflows.get("in");
		final int LIMIT = 40;
		long result = 0L;
		
		int x = 1, m = 1, a = 1, s = 1;
		String rule = accepted(x, m, a, s);
		
		if (!rule.equals("")) // x>2187
			
		
		
		/*for (int x = 1; x <= LIMIT; x++) {
			for (int m = 1; m <= LIMIT; m++) {
				for (int a = 1; a <= LIMIT; a++) {
					for (int s = 1; s <= LIMIT; s++) {
						
					}
				}
			}
			System.out.println("x: " + x);
		}*/
		
		System.out.println(result);
	}
	
	private static String accepted(int x, int m, int a, int s) {
		// TODO Auto-generated method stub
		return null;
	}






















	
	


	private static boolean isAccepted(Map<String, String[]> workflows, String[] rules, int x, int m, int a, int s) throws Exception {
		String jumpToRule = "";
		
		for (int i = 0; i < rules.length-1; i++) {
			String rule = rules[i];	//a<1305:vmz
			String condition = rule.split(":")[0];
			String destiny = rule.split(":")[1];
			
			if (conditionChecks(condition, x, m, a, s)) {
				if (destiny.equals("A"))
					return true;
				else if (destiny.equals("R"))
					return false;
				else {
					jumpToRule = destiny;
					break;
				}
			}
		}
		
		if (!jumpToRule.equals(""))
			return isAccepted(workflows, workflows.get(jumpToRule), x, m, a, s);
			
		String lastDestiny = rules[rules.length-1];
		if (lastDestiny.equals("A"))
			return true;
		else if (lastDestiny.equals("R"))
			return false;
		return isAccepted(workflows, workflows.get(lastDestiny), x, m, a, s);
	}

	private static boolean conditionChecks(String condition, int x, int m, int a, int s) throws Exception {
		// a<1305
		// operators: < >
		// letters: x m a s
		
		char letter = condition.charAt(0);
		char operator = condition.charAt(1);
		int number = Integer.parseInt(condition.substring(2));
		
		switch(letter) {
			case 'x':
				if (operator == '<')
					return x < number;
				return x > number;
				
			case 'm':
				if (operator == '<')
					return m < number;
				return m > number;
							
			case 'a':
				if (operator == '<')
					return a < number;
				return a > number;
				
			case 's':
				if (operator == '<')
					return s < number;
				return s > number;
				
			default:
				throw new Exception("unexpected letter");
		}
	}
	
	private static void part1() throws Exception {
		// key: workflow name, value: list of rules
		Map<String, String[]> workflows = new HashMap<>(WORKFLOW_NUM);
		int[][] parts = new int[PART_NUM][4]; 
		
		File myObj = new File("C:\\Users\\CASA\\eclipse-workspace\\AdventOfCode2023-pt2\\src\\input19.txt");
		Scanner in = new Scanner(myObj);
		int inNum = 1;
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim().replace('{', '_');
			line = line.substring(0, line.length()-1);
			//System.out.println(line);
			
			if (inNum < 521) {
				String[] lineParts = line.split("_");
				String name = lineParts[0];
				String[] rules = lineParts[1].split(",");
				workflows.put(name, rules);
			} else {
				String[] xmas = line.split(",");
				parts[inNum - WORKFLOW_NUM - 1] = new int[] { Integer.parseInt(xmas[0].split("=")[1]), Integer.parseInt(xmas[1].split("=")[1]), Integer.parseInt(xmas[2].split("=")[1]), Integer.parseInt(xmas[3].split("=")[1]) };
			}
			
			inNum++;
		}
		
		in.close();
		System.out.println("\n input done \n");
		//System.exit(0);
	
		final String[] IN_WORKFLOW = workflows.get("in");
		int result = 0;
		
		for (int i = 0; i < PART_NUM; i++) {
			int[] part = parts[i];
			int x = part[0], m = part[1], a = part[2], s = part[3];
			if (isAccepted(workflows, IN_WORKFLOW, x, m, a, s))
				result += x + m + a + s;
		}
		
		System.out.println(result);
	}

}
