#include <iostream>
using namespace std;

int main() {
	// your code goes here
		int ch,i,j,k=1;
	char choice;
//	clrscr();
	do
	{
		cout<<"Press 1:Pattern 1\n";
		cout<<"Press 2:Pattern 2\n";
		cout<<"Press 3:Pattern 3\n";
		cout<<"Press 4:Pattern 4\n";
		cin>>ch;
		switch(ch)
		{
			case 1:
			for(i=1;i<5;i++)
			{
			 for(j=1;j<=i;j++)
			{
			cout<<i;
			}
			cout<<endl;
			}
			break;
			
			case 2:
			for(i=1;i<=5;i++)
			{
			 for(j=1;j<=i;j++)
			{
			cout<<j;
			}
			cout<<endl;
			}
			break;

			case 3:
			for(i=1;i<=5;i++)
			{
			 for(j=1;j<=i;j++)
			{
			 cout<<k++;
			}
			cout<<endl;
			}
			
			break;
			case 4:
			k=1;
			for(i=1;i<=5;i++)
			{
			for(j=1;j<=i;j++)
			{
			cout<<k++;
			}
			cout<<endl;
			}
			break;
			}
		cout<<"Do you want to Continue(Y?N)?";
cin>>choice;
}while(choice=='Y'||choice=='y');
return 0;
}
