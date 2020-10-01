//Practical 4.5:WAP of virtual base class
#include<iostream.h>
#include<conio.h>
#include<stdio.h>
class student
{
	char name[20];
	int Roll_no;
public:
	void get()
	{
		cout<<"Enter Roll No:";
		cin>>Roll_no;
		cout<<endl<<"Enter Name:";
		cin>>name;
	}
	void disp()
	{
		cout<<"Roll No:"<<Roll_no<<endl;
		cout<<"Name:"<<name<<endl;
	}
};
class sport:virtual public student
{
	int s_mark;
public:
	void getdata()
	{
		cout<<"Enter Sports Marks";
		cin>>s_mark;
	}
	void display()
	{
		cout<<endl<<"Sports Marks:"<<s_mark;
	}
};
class Test:virtual public student
{
	int T_mark;
public:
	void get1()
	{
		cout<<"Enter Test Marks";
		cin>>T_mark;	
	}
	void disp1()
	{
		cout<<endl<<"Test Marks:"<<T_mark;
	}

};
class result:public sport, public Test
{
public:
	void put()
	{
		disp();//display func of class student
		display(); //display func of class sport
		disp1(); //display func of class Test
		//cout<<"Total marks is "<<s_mark+T_mark;
	}
};
void main()
{	
	clrscr();
	result r;
	r.get();//get func of class student
	r.getdata();//get func of class sport
	r.get1();//get func of class Test
	r.put();
	getch();
}