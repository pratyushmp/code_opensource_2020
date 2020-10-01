//Practical 2.10:WAP to add subtract multiplication and division using two array
#include<iostream.h>
#include<conio.h>
class arr
{
	int a[10],b[10],c[10];
public:
	void input();
	void output();
};
void arr::input()
{
	cout<<"Enter the value of a"<<endl;
	for(int i=0;i<4;i++)
	{
		cin>>a[i];
	}
	cout<<"Enter the value of b"<<endl;
	for(i=0;i<4;i++)
	{
		cin>>b[i];
	}
}
void arr::output()
{
	for(int i=0;i<4;i++)
		{
			c[i]=a[i]+b[i];
			cout<<"Addition is:"<<c[i]<<endl;
		}
	for(i=0;i<4;i++)
		{
			c[i]=a[i]-b[i];
			cout<<"Subtraction is:"<<c[i]<<endl;
		}
	for(i=0;i<4;i++)
		{
			c[i]=a[i]*b[i];
			cout<<"Multiplication is:"<<c[i]<<endl;
		}
	for(i=0;i<4;i++)
		{
			c[i]=a[i]/b[i];
			cout<<"Division is:"<<c[i]<<endl;
		}

}
void main()
{
	clrscr();
	arr obj1;
	obj1.input();
	obj1.output();
	getch();
}