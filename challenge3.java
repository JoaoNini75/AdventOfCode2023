package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class challenge3 {

	public static void main(String[] args) {
		try {
			File myObj = new File(
					"C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input3.txt");
			Scanner myReader = new Scanner(myObj);
			char[][] matrix = new char[140][140];

			int i = 0;
			while (myReader.hasNextLine())
				matrix[i++] = myReader.nextLine().toCharArray();

			myReader.close();
			int result = 0;

			for (i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					char ch = matrix[i][j];
					System.out.println("i: " + i + "  j: " + j + "  ch: " + ch);

					if (ch == '*')
						result += searchGear(i, j, matrix);

					// System.out.println("curr: " + curr + " res: " + result + "\n");
				}

				// if (i == 1) break;
				// System.out.println("i: " + i);
			}

			System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static int[] getTopBottom(char[][] m, int i, int j, boolean isTop) {
		int[] result = new int[2]; // result[0] -> nums multiplied ; result[1] -> num of gears
		result[0] = 1;

		int line = isTop ? i - 1 : i + 1;

		if (!(Character.isDigit(m[line][j - 1]) || Character.isDigit(m[line][j]) || Character.isDigit(m[line][j + 1])))
			return result;

		char mid = m[line][j];

		String right = "";
		for (int b = j + 1; b <= 139; b++) {
			char ch = m[line][b];
			if (Character.isDigit(ch))
				break;
			right += ch;
		}

		String left = "";
		for (int b = j - 1; b >= 0; b--) {
			char ch = m[line][b];
			if (!Character.isDigit(ch))
				break;
			left = ch + left;
		}

		if (!Character.isDigit(mid)) {
			try {
				result[0] *= Integer.parseInt(left);
				result[1]++;
			} catch (NumberFormatException e) {}
			
			try {
				result[0] *= Integer.parseInt(right);
				result[1]++;
			} catch (NumberFormatException e) {}
			
		} else {
			String res = left + mid + right;
			try {
				result[0] = Integer.parseInt(res);
				result[1] = 1;
			} catch (NumberFormatException e) {
				System.out.println("ERRORRRR");
			}
		}
		
		return result;
	}

	private static int getLeftRight(char[][] m, int i, int j, boolean isLeft) {
		int col = isLeft ? j - 1 : j + 1;

		if (!(Character.isDigit(m[i - 1][col]) || Character.isDigit(m[i][col]) || Character.isDigit(m[i + 1][col])))
			return 0;

		//char mid = m[i][col];  // TODO NAO VER NUMEROS NA VERTICAL!

		String top = "", mid = "", bot = "";
		if (!isLeft) {
			for (int a = i + 1; a <= 139; a++) {
				char ch = m[a][col];
				if (Character.isDigit(ch)) {
					bot += ch;
				} else {
					break;
				}
			}
		} else {
			
		}
		
		/*String bot = "";
		for (int a = i + 1; a <= 139; a++) {
			char ch = m[a][col];
			if (Character.isDigit(ch)) {
				bot += ch;
			} else {
				break;
			}
		}

		String top = "";
		for (int b = j - 1; b >= 0; b--) {
			char ch = m[b][col];
			if (Character.isDigit(ch)) {
				top = ch + top;
			} else {
				break;
			}
		}

		String res = "";

		try {
			Integer.parseInt(bot);
			res += bot;
		} catch (NumberFormatException e) {
		}

		if (Character.isDigit(mid))
			res += mid;

		try {
			Integer.parseInt(top);
			res += top;
		} catch (NumberFormatException e) {
		}
		 */
		return 0;//Integer.parseInt(res);
	}

	private static int searchGear(int i, int j, char[][] m) {
		int result = 1;
		int gears = 0;
		
		int top[] = getTopBottom(m, i, j, true);
		if (top[0] > 1) {
			gears += top[1];
			result *= top[0];
		}
			
		int bot[] = getTopBottom(m, i, j, false);
		if (bot[0] > 1) {
			gears += bot[1];
			result *= bot[0];
		}
		
		int left = getLeftRight(m, i, j, true);
		if (left > 1) {
			if (gears == 2)
				return 0;
			gears++;
			result *= left;
		}
			
		int right = getLeftRight(m, i, j, false);
		if (right > 1) {
			if (gears == 2)
				return 0;
			gears++;
			result *= right;
		}
		
		return result;
		

		/*if (i == 0 && j == 0) {
			result *= getTopBottom(m, i, j, false) * getLeftRight(m, i, j, false);
		} else if (i == 0 && j < 139) {

		}

		int aMin = 0, aMax = 0, bMin = 0, bMax = 0;

		if (i > 0 && i < 139) {
			aMin = -1;
			aMax = 1;
		} else if (i == 0) {
			aMin = 0;
			aMax = 1;
		} else {
			aMin = -1;
			aMax = 0;
		}

		if (j > 0 && j < 139) {
			bMin = -1;
			bMax = 1;
		} else if (j == 0) {
			bMin = 0;
			bMax = 1;
		} else {
			bMin = -1;
			bMax = 0;
		}

		for (int a = aMin; a <= aMax; a++) {
			for (int b = bMin; b <= bMax; b++) {
				if (a == 0 && b == 0)
					continue;

				int res = getNumber(m, i + a, j + b, a, b);
				if (res > 0) {
					if (gears == 2)
						return 0;

					gears++;
					result *= res;
				}
			}
		}

		return result;*/
	}

	private static boolean digitHasSymbol(int i, int j, char[][] m) {
		// System.out.println(i + " " + j);

		if (i > 0 && i < 139 && j > 0 && j < 139
				&& (isSymbol(m[i - 1][j - 1]) || isSymbol(m[i - 1][j]) || isSymbol(m[i - 1][j + 1])
						|| isSymbol(m[i][j - 1]) || isSymbol(m[i][j + 1]) || isSymbol(m[i + 1][j - 1])
						|| isSymbol(m[i + 1][j]) || isSymbol(m[i + 1][j + 1])))
			return true;

		if (i == 0 && j > 0 && j < 139 && (isSymbol(m[i][j - 1]) || isSymbol(m[i][j + 1]) || isSymbol(m[i + 1][j - 1])
				|| isSymbol(m[i + 1][j]) || isSymbol(m[i + 1][j + 1])))
			return true;

		if (i == 139 && j > 0 && j < 139 && (isSymbol(m[i - 1][j - 1]) || isSymbol(m[i - 1][j])
				|| isSymbol(m[i - 1][j + 1]) || isSymbol(m[i][j - 1]) || isSymbol(m[i][j + 1])))
			return true;

		if (i == 0 && j == 0 && (isSymbol(m[i][j + 1]) || isSymbol(m[i + 1][j]) || isSymbol(m[i + 1][j + 1])))
			return true;

		if (i > 0 && i < 139 && j == 0 && (isSymbol(m[i - 1][j]) || isSymbol(m[i - 1][j + 1]) || isSymbol(m[i][j + 1])
				|| isSymbol(m[i + 1][j]) || isSymbol(m[i + 1][j + 1])))
			return true;

		if (i == 139 && j == 0 && (isSymbol(m[i - 1][j]) || isSymbol(m[i - 1][j + 1]) || isSymbol(m[i][j + 1])))
			return true;

		if (i == 0 && j == 139 && (isSymbol(m[i + 1][j]) || isSymbol(m[i + 1][j - 1]) || isSymbol(m[i][j - 1])))
			return true;

		if (i > 0 && i < 139 && j == 139 && (isSymbol(m[i - 1][j - 1]) || isSymbol(m[i - 1][j]) || isSymbol(m[i][j - 1])
				|| isSymbol(m[i + 1][j - 1]) || isSymbol(m[i + 1][j])))
			return true;

		if (i == 139 && j == 139 && (isSymbol(m[i][j - 1]) || isSymbol(m[i - 1][j]) || isSymbol(m[i - 1][j - 1])))
			return true;

		return false;
	}

	private static boolean isSymbol(char c) {
		return !Character.isDigit(c) && c != '.';
	}

	private static int part1(char[][] matrix) {
		int result = 0;
		String curr = "";
		boolean hasSymbol = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				char ch = matrix[i][j];
				System.out.println("i: " + i + "  j: " + j + "  ch: " + ch);

				if (Character.isDigit(ch)) {
					curr += ch;
					if (hasSymbol == false && digitHasSymbol(i, j, matrix)) {
						hasSymbol = true;
					}

				} else if (!curr.equals("")) {
					if (hasSymbol) {
						result += Integer.parseInt(curr);
						hasSymbol = false;
					}

					curr = "";
				}

				// System.out.println("curr: " + curr + " res: " + result + "\n");
			}

			// if (i == 1) break;
			// System.out.println("i: " + i);
		}

		return result;
	}

}
