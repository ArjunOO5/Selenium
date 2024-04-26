package programs;
import java.util.Scanner;
public class Scannerip {


	public static void main(String[] args) {
		try (Scanner name = new Scanner(System.in)) {
			System.out.println("Enter your name");
			 String ownString = name.nextLine();
			 System.out.println(ownString);
		}
		
	}

}
