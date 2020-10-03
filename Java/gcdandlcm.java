import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      int n1=sc.nextInt();
      int n2=sc.nextInt();
      int on1=n1;
      int on2=n2;
      while(n1%n2!=0){
          int rev=n1%n2;
           n1=n2;
           n2=rev;
         
      }
      int gcd=n2;
      int lcm=(on1*on2)/gcd;
      System.out.println(n2);
      System.out.println(lcm);
     }
    }