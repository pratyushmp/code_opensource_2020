import java.util.*;import java.io.*;
class potential
{
    public static void main()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Sentence");int s;
        String k=in.nextLine();char ch=k.charAt(k.length()-1);
        if(ch == '.' || ch == '?' || ch=='!')
        {
            k=k.toUpperCase();
            StringTokenizer kt=new StringTokenizer(k," ,.,!,?");
             int c=kt.countTokens();String w[]=new String[c];
             int a[]=new int[c];
             System.out.println(c);
             for(int i=0;i<c;i++)
             {
                 String kg=kt.nextToken();
                 w[i]=kg;s=0;
                 for(int j=0;i<kg.length();i++)
                 {
                     s=s+(int)kg.charAt(j);
                    }
                        
                    System.out.println(w[i]+"\t");
                }
                
            }
        }
    }
