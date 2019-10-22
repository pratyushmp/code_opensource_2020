import java.util.Scanner;
public class ValidateIP {
    public static void main(String[] args) {
        System.out.println("Enter ip address:\n");
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        if(isValidIP(ip)) {
            System.out.println("This is valid ip address");
        } else {
            System.out.println("Not a valid ip address");
        }
    }


    static boolean isValidIP (String ip) {
        try {
            if ( ip == null || ip.isEmpty() ) {
                return false;
            }

            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }

            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            if ( ip.endsWith(".") ) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}