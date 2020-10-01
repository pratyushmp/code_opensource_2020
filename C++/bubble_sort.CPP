//Bubble sort Program Time complexity is O(n^2)

#include<iostream>
using namespace std;

int main ()
{

  int n, a[50], i, j, temp;
  //Taking the input from the user
  cout<<"enter number of elements that you want to store:\n";
  cin>>n;
 
  for (i = 0; i < n; i++)
    {
      cin>>a[i];  // stores the values in the arrays.
    }
  for (i = 0; i < n - 1; i++)
    {
      for (j = i + 1; j < n; j++)
	{
	  if (a[i] > a[j])	//if you change the relational operator u will get desceding order
	    {
	      temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
	    }
	}
    }
  cout<<"acending order of the elements is:";
  for (i = 0; i < n; i++)
    {
      cout<<"\t"<<a[i];  //prints the sorted element in order
    }
  return 0;
}
