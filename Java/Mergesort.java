package practice;

import java.util.Random;
import java.util.Scanner;

public class Mergesort {
	
	public static void mergesort(int a[], int low, int high)
	{
		int mid;
		if(high>low)
		{
			mid = (high+low)/2;
			mergesort(a,low,mid);
			mergesort(a,mid+1,high);
			merge(a,low,mid,high);
		}
		
	}
	
	public static void merge(int a[], int low, int mid, int high)
	{
		int k = low,i=low,j=mid+1;
		int c[] = new int[100];
		
		while((i<=mid) && (j<=high))
		{
			if(a[i]<=a[j])
			{
				c[k] = a[i];
				i+=1;
			}
			else
			{
				c[k] = a[j];
				j+=1;
			}
			k+=1;
		}
		
		while(i<=mid)
		{
			c[k] = a[i];
			k+=1;
			i+=1;
		}
		while(j<=high)
		{
			c[k] = a[j];
			k+=1;
			j+=1;
		}
		
		for(i=low;i<=high;i++)
			a[i] = c[i];
	}
	
	public static void main(String args[])
	{
		int i,n;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		n = in.nextInt();
		Random rand = new Random();
		int a[] = new int[100];
		
		try
		{
			for(i=0;i<n;i++)
				a[i] = rand.nextInt(50);
			System.out.println("Random elements generated are:");
			for(i=0;i<n;i++)
				System.out.println(a[i]+" ");
			long start_t = System.nanoTime();
			mergesort(a,0,n-1);
			long end_t = System.nanoTime();
			long t = end_t-start_t;
			System.out.println("Sorted elements are:");
			for(i=0;i<n;i++)
				System.out.println(a[i]+" ");
			System.out.println("Time taken to sort:"+t);
		}
		
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array overload");
		}
	}
}
