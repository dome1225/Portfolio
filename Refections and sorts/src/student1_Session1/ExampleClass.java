package student1_Session1;

public class ExampleClass {
	private int number1 = 123456789;
	public int number2 =31;
	
	public ExampleClass() {
		
	}
	
	private ExampleClass(int num) {
		System.out.println("number in: " + num + "\nnumber stored: " + number1);
	}
	
	public void getNumber() {
		System.out.println("Number is: " + number1);
	}
}
