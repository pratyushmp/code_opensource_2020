#include<stdio.h>
#include<conio.h>
void main()
{

int i,j,k,p=0,q=1,ch,val1,fact=1,c;

clrscr();
do
{

printf("Press 1: Fibonacci series\n");
printf("Press 2: Factorial of a number\n");
scanf("%d",&ch);
switch(ch)
{
case 1:
printf("Enter Fibonacci Series:");
scanf("%d",&i);
for(j=0;j<i;j++)
	{
	k=p+q;
	p=q;
	q=k;
	printf(" %d ",k);
	}
break;
case 2:

	printf("Enter the Number");
	scanf("%d",&val1);
	for(i=1;i<=val1;i++)
	{
	fact=fact*i;
	}
	printf("\nThe factorial of %d is %d",val1,fact);

break;
}

printf("\nDo you want to continue");
scanf("%c",&c);
}while(c==1);

getch();
}