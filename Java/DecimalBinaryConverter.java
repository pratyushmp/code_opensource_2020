import java.util.Scanner;

public class DecimalBinaryConverter {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Options:\n b: binary to decimal\n d: decimal to binary");
        String response = keyboard.next();
        if (response.equalsIgnoreCase("d")) {
            System.out.println("Enter the decimal value you would like to convert to binary");
            int decimal = keyboard.nextInt();
            String dtob = decimalToBinary(decimal);
            System.out.println("Decimal : " + decimal + "\nBinary: " + dtob);
        }
        if (response.equalsIgnoreCase("b")) {
            System.out.println("Enter the binary value you would like to convert to decimal");
            String binary = keyboard.next();
            int btd = binaryToDecimal(binary);
            System.out.println("Binary : " + binary + "\nDecimal: " + btd);
        }
        keyboard.close();
    }

    public static String decimalToBinary(int n) {
        String binary = "";
        while (n > 0) {
            if (n % 2 == 1) {
                binary += "1";
            } else {
                binary += "0";
            }
            n = n / 2;
        }
        String temp_binary = "";
        for (int i = binary.length() - 1; i >= 0; i--) {
            temp_binary += binary.charAt(i);
        }
        binary = temp_binary;
        return (binary);
    }

    public static int binaryToDecimal(String n) {
        int decimal = 0;
        for (int i = n.length(); i > 0; i--) {
            if (n.charAt(i - 1) == '1') {
                decimal += Math.pow(2, n.length() - i);
            }
        }
        return decimal;
    }
}
