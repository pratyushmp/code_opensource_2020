package refresherTask;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String reversedString = "";
		char[] stringToReverse = sc.nextLine().toLowerCase().toCharArray();

		for(int i = stringToReverse.length; i > 0; i--) {
			reversedString += stringToReverse[i-1];
		}
		System.out.println(reversedString);
			
		sc.close();
	}
}
