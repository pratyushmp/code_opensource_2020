//Practical 2.9
//WAP to accept two strings from the user and perform all inbuilt method
#include<iostream.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>
class StringDemo
{
	char s1[10],s2[10];
	public:
		void get()
		{
			cout<<"Enter First String:"<<endl;
			cin>>s1;
			cout<<"Enter Second String:"<<endl;
			cin>>s2;
		}	
		void display()
		{
			again:
			cout<<"Select your Choice"<<endl;
			cout<<"Press 1:Copy"<<endl;
			cout<<"Press 2:Reverse"<<endl;
			cout<<"Press 3:Concatenate"<<endl;
			cout<<"Press 4:Length"<<endl;
			cout<<"Press 5:UpperCase"<<endl;
			cout<<"Press 6:UowerCase"<<endl;
			cout<<"Press 7:Compare"<<endl;
			int ch;
			cin>>ch;
			switch(ch)
			{
				case 1:
					cout<<endl<<"Copying two String";
					char s3[10],s4[10];
					cout<<endl<<strcpy(s3,s1);
					cout<<endl<<strcpy(s4,s2);
					break;

				case 2:
					cout<<endl<<"Reversing two String";
					cout<<endl<<strrev(s1);
					cout<<endl<<strrev(s2);
					break;

				case 3:
					cout<<endl<<"Concatenating two Strings";
					cout<<endl<<strcat(s1,s2);
					break;

				case 4:
					cout<<endl<<"Length of String";
					int i=strlen(s1);
					cout<<endl<<"Length is:"<<i;
					break;
					
				case 5:
					cout<<endl<<"Upper Strings";
					cout<<endl<<strupr(s1);
					cout<<endl<<strupr(s2);
					break;

				case 6:
					cout<<endl<<"Lower Strings";
					cout<<endl<<strlwr(s1);
					cout<<endl<<strlwr(s2);
					break;

				case 7:
					cout<<endl<<"Comparing two Strings";
					int j=strcmp(s1,s2);
					if(j==0)
						cout<<endl<<"Strings are equal";
					else
						cout<<endl<<"Strings are not equal";
					break;
					}

				char c;
				cout<<endl<<"Do you want to continue..."<<endl;
				cin>>c;
				if(c=='y' || c=='Y')
					goto again;
				else
					exit(0);

			}

		
};
void main()
{	
	clrscr();
	StringDemo d1;
	d1.get();
	d1.display();
	getch();
}