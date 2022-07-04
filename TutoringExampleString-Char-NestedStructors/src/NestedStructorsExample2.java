
public class NestedStructorsExample2 {
	public static void main(String[] args) {
		/*
		 * Count the number of 5 or 6 within an array
		 */
		
		int[] exampleArray = {1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1};
		
		int counter = 0;
		for(int i = 0; i < exampleArray.length; i++) {
			switch (exampleArray[i]) {
			case 5:
			case 6:
				System.out.println("Number was 5 or 6");
				counter++;
				break;
			default:
				System.out.println("Number was not 5 or 6");
			}
		}
		System.out.println("Number of 5 or 6: " + counter);
	}
}
