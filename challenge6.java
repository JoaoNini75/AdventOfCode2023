package adventOfCode2023;


public class challenge6 {

	public static void main(String[] args) {
		long maxTime = 40829166;
		long record = 277133813491063L; 
		
		int result = 0;
		long distance = 0L;

		for (long hold = 0; hold <= maxTime; hold++) {
			distance = hold * (maxTime - hold);
			if (distance > record)
				result++;
		}
		
		System.out.println(result);
	}

	private static void part1() {
		int[] times = new int[] {40, 82, 91, 66};
		int[] distances = new int[] {277, 1338, 1349, 1063};
		
		int result = 1, res = 0, speed = 0, distance = 0;
		
		for (int i = 0; i < 4; i++) {
			res = 0; speed = 0;
			int maxTime = times[i], record = distances[i];
			
			for (int hold = 0; hold <= maxTime; hold++) {
				speed = hold;
				
				distance = speed * (maxTime - hold);
				
				if (distance > record)
					res++;
			}
			
			result *= res;
		}
		
		System.out.println(result);
	}
}
