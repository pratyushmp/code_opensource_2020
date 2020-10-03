#include <stdio.h>

int factorial(int n){
  if(n == 0) return 1;
  else return n * factorial(n - 1);
}

int main(void) {
  int n;

  printf("Recursive Factorial\n");
  printf("Enter value: ");
  
  scanf("%d",&n);

  printf("%d! = %d\n", n, factorial(n));
  
  return 0;
}