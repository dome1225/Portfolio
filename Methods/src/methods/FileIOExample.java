package methods;

import java.io.*;
import java.util.Scanner;

public class FileIOExample {
	public static void main(String[] args) {
		//Reading
		File file = new File("C:/file.txt");
		try {
			Scanner fileScanner = new Scanner(file);
			
			while(fileScanner.hasNext()){
				System.out.println(fileScanner.nextLine());
			}
			fileScanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Writing
		/*try {
			FileWriter writer = new FileWriter("./file2.txt");
			writer.write("Test123");
			writer.write("\ntest1234");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
