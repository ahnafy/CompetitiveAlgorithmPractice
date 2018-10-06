import java.util.ArrayList;
import java.util.Scanner;

public class LeftAndRight {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int numHouses = sc.nextInt();
		String directions = sc.next();
		
		ArrayList<Integer> remainingHouses = generateRemainingHouses(numHouses);
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		for(int i = 0; i < numHouses; i++){
			if (!path.isEmpty()) {
				break;
			}
			path.add(0, i + 1);
			remainingHouses = generateRemainingHouses(numHouses);
			remainingHouses.remove(i);
			System.out.print("Initial Remaining Houses:");
			for(int j = 0; j < remainingHouses.size(); j++){
				System.out.print(remainingHouses.get(j) + " ");
			}
			System.out.println("");
			
			path = lexiDeliveryOrder(remainingHouses, directions, path);
		}
		
		for(int i = 0; i < numHouses; i++){
			System.out.println(path.get(i));
		}
		
		
	}
	
	public static ArrayList<Integer> lexiDeliveryOrder(ArrayList<Integer> remainingHouses, String directions, ArrayList<Integer> currentPath){
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		System.out.print("Current Path:");
		for(int i = 0; i < currentPath.size(); i++){
			System.out.print(currentPath.get(i) + " ");
		}
		System.out.println("");
		
		if(directions.equals("")){
			return currentPath;
		}
		
		if(directions.substring(0,1).equals("L")){
			for(int i = 0; i < remainingHouses.size(); i++){
				if(remainingHouses.get(i) < currentPath.get(currentPath.size() - 1)){
					ArrayList<Integer> remainingHousesHolder = remainingHouses;
					ArrayList<Integer> currentPathHolder = currentPath;
					String directionsHolder = directions.substring(1);
					
					currentPathHolder.add(remainingHousesHolder.get(i));
					remainingHousesHolder.remove(i);
					
					output = lexiDeliveryOrder(remainingHousesHolder, directionsHolder, currentPathHolder);
					if (!output.isEmpty()){
						break;
					}
				}
			}
		} else {
			for(int i = 0; i < remainingHouses.size(); i++){
				if(remainingHouses.get(i) > currentPath.get(currentPath.size() - 1)){
					ArrayList<Integer> remainingHousesHolder = remainingHouses;
					ArrayList<Integer> currentPathHolder = currentPath;
					String directionsHolder = directions.substring(1);
					
					currentPathHolder.add(remainingHousesHolder.get(i));
					remainingHousesHolder.remove(i);
					output = lexiDeliveryOrder(remainingHousesHolder, directionsHolder, currentPathHolder);
					
					if (!output.isEmpty()){
						break;
					}
				}
			}
		}
		
		
		for(int i = 0; i < output.size(); i++){
			System.out.print(output.get(i) + " ");
		}
		System.out.println("");
		
		return output;
	}
	
	public static ArrayList<Integer> generateRemainingHouses(int numHouses){
		ArrayList<Integer> remainingHouses = new ArrayList<Integer>();
		for(int i = 0; i < numHouses; i++){
			remainingHouses.add(i, i + 1);
		}
		
		return remainingHouses;
	}
}
