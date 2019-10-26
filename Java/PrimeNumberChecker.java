
import java.util.Scanner;

/**
 * @author dudmacedo
 */
public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a integer number to test if it is Prime (<= 1 to exit): ");

            Integer n = sc.nextInt();

            if (n <= 1) {
                System.out.println("Exiting...");
                return;
            }

            System.out.println(
                    (isPrime(n))
                    ? n + " is Prime!"
                    : n + " is Not Prime!");
        }

    }

    private static boolean isPrime(Integer n) {
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        int limit = (int) Math.sqrt(n) + 1;
        int factor = 3;

        while (factor < limit) {
            if (n % factor == 0) {
                return false;
            }
            factor += 2;
        }

        return true;
    }

}
