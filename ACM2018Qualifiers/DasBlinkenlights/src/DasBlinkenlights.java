import java.util.Scanner;

public class DasBlinkenlights {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int blinker1 = sc.nextInt();
		int blinker2 = sc.nextInt();
		int maxTime = sc.nextInt();
		boolean overlap = false;
		
		for(int i = 1; i <= maxTime; i++){
			if(i%blinker1 == 0 && i%blinker2==0){
				overlap = true;
				break;
			}
		}
		
		if(overlap){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
	}
}
