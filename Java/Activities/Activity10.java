package activities;

import java.util.HashSet;

public class Activity10 {
	public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        // Adding element to HashSet
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("A");
        hs.add("F");
        
       
        System.out.println("Original HashSet: " + hs);        
        
        System.out.println("Size of HashSet: " + hs.size());
        
        
        System.out.println("Removing A from HashSet: " + hs.remove("A"));
        //Remove element that is not present
        if(hs.remove("K")) {
        	System.out.println("K removed from the Set");
        } else {
        	System.out.println("K is not present in the Set");
        }
        
        
        System.out.println("Checking if B is present: " + hs.contains("B"));
        
        System.out.println("Updated HashSet: " + hs);
    }
}