package trianglularClouds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class triangularClouds {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int person1 = sc.nextInt();
		ArrayList<CoordinatePair> person1Triangles = new ArrayList<CoordinatePair>();
		
		int x1, x2, x3, y1, y2, y3;
		CoordinatePair cp;
		
		for (int i = 0; i < person1; i++){
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			x3 = sc.nextInt();
			y3 = sc.nextInt();
			
			cp = new CoordinatePair(x1, y1);
			person1Triangles.add(cp);
			cp = new CoordinatePair(x2, y2);
			person1Triangles.add(cp);
			cp = new CoordinatePair(x3, y3);
			person1Triangles.add(cp);
		}
		
		int person2 = sc.nextInt();
		ArrayList<CoordinatePair> person2Triangles = new ArrayList<CoordinatePair>();
		
		for (int i = 0; i < person2; i++){
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			x3 = sc.nextInt();
			y3 = sc.nextInt();
			
			cp = new CoordinatePair(x1, y1);
			person2Triangles.add(cp);
			cp = new CoordinatePair(x2, y2);
			person2Triangles.add(cp);
			cp = new CoordinatePair(x3, y3);
			person2Triangles.add(cp);
		}
		
		
		ArrayList<CoordinatePair> person1Shape = new ArrayList<CoordinatePair>();
		ArrayList<CoordinatePair> person2Shape = new ArrayList<CoordinatePair>();
		
		person1Shape = buildShape(person1Triangles);
		person2Shape = buildShape(person2Triangles);
		
		Collections.sort(person1Shape, new SortCoordinates());
		Collections.sort(person2Shape, new SortCoordinates());
		
		if(person1Shape.equals(person2Shape)){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
		
		
/*
		boolean isMatching = false;
		for(int i = 0; i < person1Triangles.size(); i++){
			for(int j = 0; j < person2Triangles.size(); j++){
				if(compareSides(person1Triangles.get(i), person2Triangles.get(j))){
					isMatching = true;
					break;
				}
			}
			if(isMatching){
				break;
			}
		}
		
		if(isMatching){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		*/
	}
	
	public static ArrayList<CoordinatePair> buildShape(ArrayList<CoordinatePair> shapes){
		ArrayList<CoordinatePair> output = new ArrayList<CoordinatePair>();
		
		for(int i = 0; i < shapes.size(); i++){
			for(int j = 0; j < shapes.size(); j++){				
				if(shapes.get(i).compareTo(shapes.get(j)) == 0){
					shapes.remove(j);
					j--;
				}
				
				if(j+1 == i){
					j++;
				}
			}
		}
		
		return output;
	}
	
	
	
	public static boolean compareSides(double[] triangle1, double[] triangle2){
		 Arrays.sort(triangle1); 
	     Arrays.sort(triangle2);
	     
	     //System.out.println(Arrays.toString(triangle1));
	     //System.out.println(Arrays.toString(triangle2));
	     
	     if (triangle1 == triangle2 ){return true;}
		
		return false;
	}
	
	

	public static double[] generateTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
		
		double[] output = {Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)), 
				Math.sqrt((x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3)),
				Math.sqrt((x3 - x2)*(x3 - x2) + (y3 - y2)*(y3 - y2))};
		
		System.out.println(Arrays.toString(output));
		
		return output;
		
		
	}
	
	public static class CoordinatePair {
		private int x;
		private int y;
		
		CoordinatePair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(CoordinatePair that){
			//if((this.x == that.x && this.y == that.y) || (this.x == that.y && this.y == that.x)){
			if((this.x == that.x && this.y == that.y)){
				return 0;
			}
			
			return -1;
		}
	}
	
	static class SortCoordinates implements Comparator<CoordinatePair> 
	{ 
	    // Used for sorting in ascending order of 
	    // roll name 
	    public int compare(CoordinatePair a, CoordinatePair b) 
	    { 
	        return a.compareTo(b); 
	    } 
	} 
}
