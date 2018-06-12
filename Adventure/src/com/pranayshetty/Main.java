package com.pranayshetty;
import java.util.*;

public class Main {
	private static Map<Integer,Location> locations=new HashMap<>();

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		Map<String ,Integer>tempExit=new HashMap<>();
		locations.put(0, new Location(0,"You are sitting in front of a computer learning java",tempExit));
		
		
		
		
		
		
		tempExit=new HashMap<>();
		tempExit.put("W", 2);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("N", 5);
		locations.put(1, new Location(1,"You are standing at the end of the road on the side of the red building",tempExit));
		
		tempExit=new HashMap<>();
		tempExit.put("N", 5);
		locations.put(2, new Location(2,"You are at the top of the hill",tempExit));
		
		tempExit=new HashMap<>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3,"You are inside a building a well house for a small spring",tempExit));
		
		
		tempExit=new HashMap<>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4,"You are in a valley beside a stream",tempExit));
		
		
		tempExit=new HashMap<>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(6,"You are in a forest",tempExit));
		
		
		
		
		
		int loc=1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			System.out.println();
			if(loc==0){
				break;
			}
			Map<String ,Integer>exits=locations.get(loc).getExits();
			System.out.println("The available exits are");
			for(String exit:exits.keySet()) {
				System.out.println(exit+" :You will be "+locations.get(exits.get(exit)).getDescription().substring(8));
			}
			System.out.println();
			System.out.println("Enter the directions");
			loc=exits.get(in.nextLine().toUpperCase());
			if(!locations.containsKey(loc)) { 
				System.out.println("You cannot go that direction");
			}
		}
	}

}
