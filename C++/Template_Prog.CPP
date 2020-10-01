//Pract5.3:WAP to display largest among two number using funtion template
#include<iostream.h>
#include<conio.h>
template <class A>
A Large(A n1,A n2)
{
	return (n1>n2 ? n1 : n2);
}
void main()
{
	int i1,i2;
	float f1,f2;
	double d1,d2;
	cout<<endl<<"Enter two integer value"<<endl;
	cin>>i1>>i2;
	cout<<"Largest No is: "<<Large(i1,i2);
	cout<<endl<<"Enter float integer value"<<endl;
	cin>>f1>>f2;
	cout<<"Largest No is: "<<Large(f1,f2);
	cout<<endl<<"Enter two double value"<<endl;
	cin>>d1>>d2;
	cout<<"Largest No is: "<<Large(d1,d2);
	getch();
}