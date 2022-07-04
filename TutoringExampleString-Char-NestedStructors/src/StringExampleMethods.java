
public class StringExampleMethods {
	
	public static void main(String[] args) {
		/*
		 * Notes:
		 * 1. String is a class
		 */
		
		
		String aString = "Example string";
		
		//Returns the length of the String
		aString.length(); 
		
		//Returns true if the String is an exact match of the inputed String, false otherwise
		aString.equals("Example String"); //Do NOT use == for Objects (String is an object)
		aString.equalsIgnoreCase("Example String");
		
		//Compares one String to another
		//negative means aString is before the inputed String, positive means after
		System.out.println(aString.compareTo("Example ztring"));
		
		
		//Gets the character at index x
		aString.charAt(0); 
		
		//Finds the first instance of the inputed String
		aString.indexOf("Seacrhed String");
		
		
		
		/*
		 * Other useful methods
		 */
		
		aString.strip();
		
		aString.split(":");
		
		aString.concat(aString);
		System.out.println(aString + aString);
		
		/*
		 * Substrings
		 */
		
		String part1 = aString.substring(0, aString.indexOf(" "));
		String part2 = aString.substring(aString.indexOf(" ") + 1);
		
		System.out.println("Part 1: \"" + part1 + "\" Part 2: \"" + part2 + "\"");
		
		return;
	}
}
//Note: methods referenced from Apoorve Chokshi powerpoint