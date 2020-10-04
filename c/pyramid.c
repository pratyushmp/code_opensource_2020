//including the libraries
#include<stdio.h>
#include<stdlib.h>

//defining the main function
int main()
{
  //declaring the variables
  int i,j, n;

  //taking input for the number of rows
  printf("Enter the number of rows in pyramid of stars:\n");
  scanf("%d", &n);

  //making loop to print rows
  for (i = 1; i <= n; i++){
  	
  	//making loop to print spaces in a row
    for (j = 1; j <= n-i; j++){
    	printf(" ");
	}  
      
    //making loop to print stars in a row
    for (j = 1; j <= 2*i - 1; j++) {
    	printf("*");
	}
    
    //printing a new line
    printf("\n");
  }

  return 0;
}
