import java.util.Scanner;

public class NestedStructuresExample1 {
	public static void main(String[] args) {
		int exampleNumber = 5;
		
		/*
		 * Switch logic
		 */
		switch (exampleNumber) {
			case 5:
			case 6:
				System.out.println("Number was 5 or 6");
				break;
			default:
				System.out.println("Number was not 5 or 6");
		}
		
		/*
		 * If else chain logic
		 */
		if(exampleNumber == 5) {
			System.out.println("Number was 5");
		}
		else if(exampleNumber == 6) {
			System.out.println("Number was 6");
		}
		else {
			System.out.println("Number was not 5 or 6");
		}
		
		/*
		 * Average calculator
		 */
		
		double total = 0;
		int numOfNumbers = 0;
		
		double inputedNumber = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number to average. Enter -1 to quit: ");
		inputedNumber = input.nextDouble();
		
		//Clears \n from input
		input.nextLine();
		
		while(inputedNumber >= 0) {
			total += inputedNumber;
			numOfNumbers++;
			
			System.out.print("Enter number to average. Enter -1 to quit: ");
			inputedNumber = input.nextDouble();
			
			//Clears \n from input
			input.nextLine();
			
		}
		
		if(numOfNumbers > 0) {
			System.out.println("The average is: " + total/numOfNumbers);
		}
		
	}
}
