package digikey;

import java.util.*;
import java.io*;
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
        	} catch (Exception e) { System.out.println(e); }

		for (int testCase = 0; testCase < 10; testCase++) {
			try {
				// CODE HERE
				output.println("THE RESULT");
				
			} catch(Exception e) { output.println("Bogus output"); } // change this to reflect the question (if there is time)
		}
		output.close();
		input.close();
	}


}
