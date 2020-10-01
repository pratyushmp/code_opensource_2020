//Pract5.4:WAP to find minimum and maximum value of different datatype in an array using template
#include<iostream.h>
#include<conio.h>
typedef int ash;
template <class T>
T min(T arr[],ash n)
{
	ash i;
	T min;
	min=arr[0];
	for(i=0; i<n; i++)
	{
		if(min>arr[i])
		{
			min=arr[i];
		}
	}
	return min;
}
template <class T>
T max(T arr[],ash n)
{
	ash i;
	T max;
	max=arr[0];
	for(i=0; i<n; i++)
	{
		if(max<arr[i])
		{
			max=arr[i];
		}
	}
	return max;
}
void main()
{
	ash iarr[5],i;
	float farr[5];
	double darr[5];
	cout<<endl<<"Enter integer value: "<<endl;
	for(i=0;i<5;i++)
	{
		cin>>iarr[i];
	}
	cout<<endl<<"Integer Minimum Value:"<<min(iarr,5);
	cout<<endl<<"Intetger Maximum Value: "<<max(iarr,5);
	getch();
}