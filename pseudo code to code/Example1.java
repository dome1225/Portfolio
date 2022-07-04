import java.util.Scanner;

/*
 * 1. PRINT “Enter the customer’s credit limit:”
 * 2. INPUT limit
 * 3. PRINT “Enter the amount currently owing:”
 * 4. INPUT owing
 * 5. available = limit – owing
 * 6. PRINT “The amount available is”
 * 7. PRINT available
 */
public class Example1 {
	public static void main(String[] args) {
		//PRINT --> System.out.print();
		//PRINT “Enter the customer’s credit limit:”
		System.out.println("Enter the customer’s credit limit: ");
		
		//INPUT --> Scanner
		Scanner input = new Scanner(System.in);
		
		//INPUT limit
		double limit = input.nextDouble();
		input.nextLine();
		
		//String stringLimit = input.nextLine();
		//double limit = Double.parseDouble(stringLimit);
		//The new line is left in the input. This removes that new line
		
		//PRINT “Enter the amount currently owing:”
		System.out.println("Enter the amount currently owing:");
		
		//INPUT owing
		double owing = input.nextDouble();
		//The new line is left in the input. This removes that new line
		input.nextLine();
		
		//available = limit – owing
		double available = limit - owing;
		
		//PRINT “The amount available is” + PRINT available
		System.out.println("The amount available is " + available);
		
	}
}
