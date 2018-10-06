import java.util.Scanner;

public class RunLengthEncoding {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input;
		String output = "";
		String instruction = sc.next();
		
		if(instruction.equals("E")){
			input = sc.next();
			output = encodeString(input);
			
		} else if(instruction.equals("D")) {
			input = sc.next();
			output = decodeString(input);
		}
		
		System.out.println(output);
	}
	
	public static String encodeString(String input){
		String output = "";
		String current = input.substring(0,1);
		int currentCounter = 1;
		
		if(input.length() == 1){
			output = output + current + currentCounter;
		} else {
			for(int i = 1; i < input.length(); i++){
				if(current.equals(input.substring(i,i+1))){
					currentCounter++;
				} else {
					output = output + current + currentCounter;
					currentCounter = 1;
					current = input.substring(i,i+1);
				}
				
				if(i + 1 == input.length()){
					output = output + current + currentCounter;
				}
			}
		}

		return output;
	}
	
	public static String decodeString(String input){
		String output = "";
		
		for(int i = 0; i < input.length(); i=i+2){
			for(int j = 0; j < Integer.parseInt(input.substring(i+1,i+2)); j++){
				output = output + input.substring(i,i+1);
			}
		}
		
		return output;
		
	}
}
