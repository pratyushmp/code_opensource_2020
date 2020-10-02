package Set1;

import java.util.*;

public class ReverseWordInSentence {

	public static String reverse(String value) {
		int len = value.length();
		char mychar = value.charAt(0);
		if (Character.isDigit(mychar)) {
			return value;

		}
		String rev = "";
		for (int i = len - 1; i >= 0; i--)
			rev = rev + value.charAt(i);
		return rev;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array = new String[20];
		System.out.println("*****Start*****");
		int count = 0;
		try {
			System.out.println("Please enter a sentence");
			boolean valid = true;
			while (true == valid) {
				if (array[count] == "\n") {
					valid = false;
					break;
				} else {
					array[count] = sc.next();
					System.out.print(reverse(array[count]) + " ");
					count++;
				}
			}
		} catch (Exception e) {
			System.out.println("Bad choice of input. Try again!");
		}
		for (int i = 0; i < count; i++) {
			System.out.print(reverse(array[i]));
		}
		System.out.println("*****End*****");
		sc.close();
	}

}
