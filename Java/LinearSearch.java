import java.util.*;
 public class LinearSearch
{
	public static void main(String[] args) {
		int index,arrayLength,elementToBeSearched,elementLocation=-1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array");
		arrayLength=sc.nextInt();
		int array[]=new int[arrayLength];
		System.out.println("Enter Elements of array");
		for(index=0;index<arrayLength;index++)
		array[index]=sc.nextInt();
		System.out.println("Enter element to be searched");
		elementToBeSearched=sc.nextInt();
		for(index=0;index<arrayLength;index++)
		{
		    if(array[index]==elementToBeSearched)
		    {
		        elementLocation=index+1;
		    }
		}
		if(elementLocation!=-1)
		System.out.println("Element found at location "+elementLocation);
		else
		System.out.println("Element not found");
	}
}

/* 
Input/Output -
Enter size of array
3
Enter Elements of array
1
3
2
Enter element to be searched
2
Element found at location 3
*/

