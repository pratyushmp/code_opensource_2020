import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;


public class Solution {

    //return the alphabetically greater string than the input string
    // A string is greater than another string if it comes later in a lexicographically sorted list.
    //Exp input : abb output: bab
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
        int cases=in.nextInt();//num of test cases
		
		for(int j=0;j<cases;j++)
		{
			String b=in.next(); //input string
			int l=b.length();
			int arr[]=new int[26];
						
			int i;
			char c='*';
			
			for(i=l-2;i>=0;i--)
			{
				if(b.charAt(i)>=b.charAt(i+1))
				{
					arr[b.charAt(i+1)-'a']++;
				}
				else
				{
					arr[b.charAt(i+1)-'a']++;
					c=b.charAt(i);
					break;
				}
			}
			
			if(c=='*')
			{
				System.out.println("no answer");
				continue;
			}
			
			for(int pos=c-'a'+1;pos<26;pos++)
			{
				if(arr[pos]>0)
				{
					arr[c-'a']++;
					arr[pos]--;
					c=(char) ('a'+pos);
					
					break;
				}
			}
			
			String res="";
			for(int count=0;count<b.length();count++)
			{
				if(count<i)
					res=res+b.charAt(count);
				else if(count==i)
					res+=c;
				else
					break;
			}
			
			for(int count=0;count<26;count++)
			{
				if(arr[count]!=0)
				{
					res+=(char)('a'+count);
					arr[count]--;
					count--;
				}
			}
			
			System.out.println(res);
		}
	}
}