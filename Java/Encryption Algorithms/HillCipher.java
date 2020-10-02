
import java.io.*;
import java.lang.*;
public class HillCipher
{
public static void main(String []arg)throws Exception
{
    int k[][]={{17,17,5}, {21,18,21}, {2,2,19}};
    int p[]=new int[300];
    int c[]=new int[300];
    int i=0;    
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("enter plain text");
    String str=br.readLine();
    
    for( i=0;i<str.length();i++)
    {
        int c1=str.charAt(i);
        //System.out.println(c1);
        p[i]=(c1)-97;
    }
                i=0;int zz=0;
        for( int b=0;b<str.length()/3;b++)
        {
        for(int j=0;j<3;j++)
        {
        for(int x=0;x<3;x++)
        {
        c[i]+=k[j][x]*p[x+zz];
        }i++;
        }
        zz+=3;
        }
                System.out.println("Encrypted Text : ");
        for(int z=0;z<str.length();z++)
        System.out.print((char)((c[z]%26)+97));
        System.out.println("decrepted Text : ");
        for(int z=0;z<str.length();z++)
        System.out.print((char)((c[z]%26)-97));    
}
}
