import java.io.File;
import java.util.Scanner;

public class challenge18 {
	
	private static final int IN_SIZE = 716;
	private static final char NIL = '\u0000';
	private static final int TERRAIN_SIZE = 550; // 3680
	private static char[][] terrain = new char[TERRAIN_SIZE][TERRAIN_SIZE];
	
	public static void main(String[] args) throws Exception {
		File myObj = new File("C:\\Users\\CASA\\eclipse-workspace\\AdventOfCode2023-pt2\\src\\input18.txt");
		Scanner in = new Scanner(myObj);
		int inNum = 0;
		
		char[] directions = new char[IN_SIZE];
		int[] distances = new int[IN_SIZE];
		int y = TERRAIN_SIZE/2, x = TERRAIN_SIZE/2;
		int result = 0;
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			System.out.println(line);
			
			char dir = line.split(" ")[0].charAt(0);
			directions[inNum] = dir;
			
			int dist = Integer.parseInt(line.split(" ")[1]);
			distances[inNum] = dist;
			
			result += dist;
			int[] yx = updateTerrain(dir, dist, y, x);
			y = yx[0];
			x = yx[1];
			
			inNum++;
		}
		
		in.close();
		System.out.println("\ninput done\n");
		//System.exit(0);
		
		/*for (int i = 0; i < TERRAIN_SIZE; i++) 
			for (int j = 0; j < TERRAIN_SIZE; j++) 
				if (terrain[i][j] != NIL)
					System.out.println("i: " + i + "  j: " + j);*/
		
		int interior = digInterior();
		result += interior;
		
		System.out.println(interior);
		System.out.println(result);
	}

	private static int digInterior() {
		int result = 0;
		boolean hor = false;
		boolean[] ver = new boolean[TERRAIN_SIZE];

		for (int i = 0; i < TERRAIN_SIZE; i++) {
			for (int j = 0; j < TERRAIN_SIZE; j++) {
				char ch = terrain[i][j];
				
				if (ch == NIL) {
					if (ver[j] && hor)
						result++;
				} else {
					ver[j] = !ver[j];
					hor = !hor;
				}
			}
			
			hor = false;
		}
		
		return result;
	}

	private static int[] updateTerrain(char dir, int dist, int y, int x) {
		switch(dir) {
			case 'R':
				for (int ctr = 0; ctr < dist; ctr++)
					terrain[y][x++] = '#';
					
				break;
				
			case 'L':
				for (int ctr = 0; ctr < dist; ctr++)
					terrain[y][x--] = '#';
				
				break;	
				
			case 'D':
				for (int ctr = 0; ctr < dist; ctr++)
					terrain[y++][x] = '#';
				
				break;
				
			case 'U':
				for (int ctr = 0; ctr < dist; ctr++)
					terrain[y--][x] = '#';
	
				break;
		}
		
		return new int[] {y, x};
	}

}
