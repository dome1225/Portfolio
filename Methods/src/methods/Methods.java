package methods;

import java.util.ArrayList;

public class Methods {

	private int test1 = 1;
	private int test2 = 2;
	
	public static void main(String[] args) {
		
		
		ArrayList<String> arraylist = new ArrayList<String>();
		
		Methods example = new Methods();
		
		example.name("Test");
		
		System.out.println(example);
	}
	
	public Methods() {
		System.out.println("Object creation");
		test1 =4;
	}
	
	public Methods(int number, int number2) {
		System.out.println("Object creation");
	}
	
	protected void name(String name) {
		System.out.println(name);
	}
	
	public int name2() {
		return 0;
	}
	
	public String toString() {
		return "Example class test1: " + test1 + " test2: " + test2;
		
	}
	
}
