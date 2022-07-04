
public class Example2 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 9;
		
		if(num1 > num2) {
			System.out.println("num1 is greater than num2");
		}
		else if(num1 < num2) {
			System.out.println("num1 is less than num2");
		}
		else {
			System.out.println("num1 is equal to num2");
		}
		
		int num3 = 1;
		switch (num3) {
		case 1: 
			System.out.println("1");
			break;
			
		case 2: 
			System.out.println("2");
			break;
		
		case 3: 
			System.out.println("3");
			break;
			
		default: 
			System.out.println("I can only count to 3");
			break;
		}
		
		int input = 0;
		while(input == 0) {
			System.out.println("While entered");
			input = 1;
		}
		
		input = 0;
		
		do{
			System.out.println("Do while entered");
			input = 1;
		} while(input == 0);
		
		
		
		for(int i = 0; i < 5; i++) {
			System.out.println("for loop");
		}
	
	}
}
