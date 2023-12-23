package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class challenge1 {

	static String[] nums = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	public static void main(String[] args) {
		/*String one = "one";
		String on = "on";
		System.out.println(one.substring(0, on.length()).equals(on));
		
		String[] nums2 = reverseStrings(nums);
		for (int i = 0; i < nums2.length; i++)
			System.out.println(nums2[i]);
		
		String test = "8sevengzfvjrhnsb6ddb8ninerkgkxthtfkvbcmqs";
		String test2 = "four2tszbgmxpbvninebxns6nineqbqzgjpmpqr";
		System.out.println(test2);
		//System.out.println(findFirstDigit(test2, false));
		System.out.println(findFirstDigit(revString(test), true));
		
		
		String test3 = "7pqrstsixteen";
		String test4 = "eighthreeighthreeight";
		
		System.out.println(findFirstDigit(test3, false));
		System.out.println(findFirstDigit(revString(test3), true));
		System.exit(0);*/
		
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input1.txt");
			Scanner myReader = new Scanner(myObj);
			int result = 0;
			
			int i = 1;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				char first = findFirstDigit(line, false);
				char last = findFirstDigit(revString(line), true);
				String num = "" + first + last;
				result += Integer.parseInt(num);
				
				System.out.println("line: " + line + "   first: " + first + "  last: " + last + "  res: " + result);
				
				//if (i == 10) break;
				i++;
			}
			
			myReader.close();
			System.out.println(result);
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	private static char findFirstDigit(String s, boolean reved) {
		String currWord = "";
		String[] actualNums = reved ? reverseStrings(nums) : nums;
		
	    for (int i = 0; i < s.length(); i++) {
	    	char ch = s.charAt(i);
	    	if (Character.isDigit(ch))
	    		return s.charAt(i);
	    	
	    	String newWord = currWord + ch;
	    	boolean valid = false;
	    	for (int j = 0; j < actualNums.length; j++) {
	    		if (actualNums[j].equals(newWord))
	    			return Character.forDigit(j+1, 10);
	    		
	    		//System.out.println(newWord + "   " + actualNums[j].substring(0, newWord.length()));
	    		
	    		if (newWord.length() <= actualNums[j].length() && actualNums[j].substring(0, newWord.length()).equals(newWord)) {
	    			currWord = newWord;
	    			valid = true;
	    			break;
	    		}
	    	}
	    	
	    	if (!valid)
	    		currWord = "" + ch;
	    	
	    	//System.out.println(currWord);
	    }
	    	
	    return ' ';
	}
	
	private static char findLastDigit(String s) {
		String[] nums2 = reverseStrings(nums);
		
		String currWord = "";
		
		for (int i = s.length()-1; i >= 0; i--) {
	    	char ch = s.charAt(i);
	    	if (Character.isDigit(ch))
	    		return s.charAt(i);
	    	
	    	String newWord = ch + currWord;
	    	boolean valid = false;
	    	for (int j = 0; j < nums2.length; j++) {
	    		if (nums2[j].equals(newWord))
	    			return Character.forDigit(j+1, 10);
	    		
	    		if (newWord.length() <= nums2[j].length() && nums2[j].substring(0, newWord.length()).equals(newWord)) {
	    			currWord = newWord;
	    			valid = true;
	    			break;
	    		}
	    	}
	    	
	    	if (!valid)
	    		currWord = "";
	    	
	    	System.out.println(currWord);
	    }
	    	
	    return ' ';
	}

	private static String[] reverseStrings(String[] nums) {
		String[] res = new String[nums.length];
		for (int i = 0; i < nums.length; i++) 
			res[i] = revString(nums[i]);
		return res;
	}

	private static String revString(String string) {
		String res = "";
		for (int i = 0; i < string.length(); i++) 
			res = string.charAt(i) + res;
		return res;
	}
}
