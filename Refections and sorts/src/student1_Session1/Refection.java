package student1_Session1;

import java.lang.reflect.*;

public class Refection {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<?> exampleClass = Class.forName("student1.ExampleClass");
		
		Field[] exampleClassFields = exampleClass.getDeclaredFields();
		
		Constructor<?>[] exampleClassConstructorList = exampleClass.getDeclaredConstructors();
		
		Constructor<?>  exampleClassConstructor = exampleClass.getDeclaredConstructor(int.class);
		
		//Create a instance of ExampleClass
		exampleClassConstructor.setAccessible(true);
		ExampleClass class1 = (ExampleClass) exampleClassConstructor.newInstance(5);
		
		//Access the number1 field ignoring the private flag
		Field exampleClassField = exampleClass.getDeclaredField("number1");
		exampleClassField.setAccessible(true);
		exampleClassField.setInt(class1, 0);
		
		class1.getNumber();
		
		Method[] exampleClassMethods = exampleClass.getDeclaredMethods();
		exampleClassMethods[0].invoke(class1);


	}
}
