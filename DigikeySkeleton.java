package digikey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;

public class Digikey {
	public static void main(String args[]) {
		Scanner input = null;
        	PrintWriter output = null;
        	try {
	    		// IMPORTANT! change these for each problem!!
            		input = new Scanner(new File("C:\DKC3\problemIn.txt"));
// 			input = new Scanner(System.in); // for our own tests. make sure to comment out when done
            		output = new PrintWriter("C:\DKC3\problemOut.txt");
        	} catch (Exception e) { System.out.println("crap " + e); }
		
		String inputPath = ""; // change to actual path
		String outputPath = "";

		for (int testCase = 0; testCase < 10; testCase++) {

			// CODE HERE


			output.println("THE RESULT");
		}
		output.close();
		input.close();
	}


}

class Seconds {
	public static void main(String args[]) {
		String inputPath = ""; // change to actual path
		String outputPath = "";
		//		Scanner file = new Scanner(inputPath);
		Scanner file = new Scanner(System.in); // use standard input for testing ourselves

		for (int testCase = 0; testCase < 10; testCase++) {
			try {
				int hours = file.nextInt();
				int minutes = file.nextInt();
				int seconds = file.nextInt();

				if(hours >= 12) {
					hours %= 12;
				}

				int sum = (hours * 60 * 60) + (minutes * 60) + seconds;


				System.out.println(sum);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
