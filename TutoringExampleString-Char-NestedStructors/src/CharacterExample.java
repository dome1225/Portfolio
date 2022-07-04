import java.util.Scanner;

public class CharacterExample {
	public static void main(String[] args) {
		/*
		 * Notes:
		 * 1. Character is a wrapper class for char (char is a primitive).
		 *  
		 */
		char letter;
		
		System.out.print("Insert character: ");
		Scanner input = new Scanner(System.in);
		
		letter = input.next().charAt(0);
		
		System.out.println("Digit: " + Character.isDigit(letter));
		System.out.println("Letter: " + Character.isLetter(letter));
		System.out.println("Letter or digit: " + Character.isLetterOrDigit(letter));
		System.out.println("Lower case: " + Character.isLowerCase(letter));
		System.out.println("Upper case: " + Character.isUpperCase(letter));
		System.out.println("Space: " + Character.isSpace(letter));
		System.out.println("Whitespace: " + Character.isWhitespace(letter));
	}
}
//Note: methods referenced from Apoorve Chokshi powerpoint