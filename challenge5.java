package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class challenge5 {

	public static void main(String[] args) {
		try {
			File myObj = new File("C:\\Users\\paulo\\CVS Workspace\\adventOfCode2023\\src\\adventOfCode2023\\input5.txt");
			Scanner myReader = new Scanner(myObj);
			String[] input = new String[188];
			int in = 1;
			int result = 0;
			
			// resultado inicio range
			
			while (myReader.hasNextLine()) 
				input[in++] = myReader.nextLine().trim();
			myReader.close();
			
			String[] seeds = input[1].split(": ")[1].trim().split(" ");
			String[][] seedsSoil = new String[17][3], soilFert = new String[14][3], 
					fertWater = new String[31][3], waterLight = new String[18][3], lightTemp = new String[45][3],
					tempHum = new String[38][3], humLoc = new String[9][3];
			
			
			//String[][] maps = new String[172][3];
			
			for (int i = 3; i < input.length; i++) {
				switch (input[i]) {
					case "seed-to-soil map:":
						for (int j = i+1, k = 0; j < i+1+seedsSoil.length; j++, k++)
							seedsSoil[k] = input[j].split(" ");
						i = i+1+seedsSoil.length;
						break;
						
					case "soil-to-fertilizer map:":
						for (int j = i+1, k = 0; j < i+1+soilFert.length; j++, k++)
							soilFert[k] = input[j].split(" ");
						i = i+1+soilFert.length;
						break;
						
					case "fertilizer-to-water map:":
						for (int j = i+1, k = 0; j < i+1+fertWater.length; j++, k++)
							fertWater[k] = input[j].split(" ");
						i = i+1+fertWater.length;
						break;
						
					case "water-to-light map:":
						for (int j = i+1, k = 0; j < i+1+waterLight.length; j++, k++)
							waterLight[k] = input[j].split(" ");
						i = i+1+waterLight.length;
						break;
						
					case "light-to-temperature map:":
						for (int j = i+1, k = 0; j < i+1+lightTemp.length; j++, k++)
							lightTemp[k] = input[j].split(" ");
						i = i+1+lightTemp.length;
						break;
						
					case "temperature-to-humidity map:":
						for (int j = i+1, k = 0; j < i+1+tempHum.length; j++, k++)
							tempHum[k] = input[j].split(" ");
						i = i+1+tempHum.length;
						break;
						
					case "humidity-to-location map:":
						for (int j = i+1, k = 0; j < i+1+humLoc.length; j++, k++)
							humLoc[k] = input[j].split(" ");
						i = i+1+humLoc.length;
						break;
						
					default:
						break;
				}
			}
			
			String[][][] map = new String[][][] { seedsSoil, soilFert, fertWater, waterLight, lightTemp, tempHum, humLoc };
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					for (int k = 0; k < map[i][j].length; k++) {
						System.out.println(map[i][j][j]);
					}
				}
			}
			
			//System.out.println(result);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
