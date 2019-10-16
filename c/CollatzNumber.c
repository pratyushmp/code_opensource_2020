/*
How this sequence works ??
Basically, it pick a number and than check if this number is
even or odd. 
If the number is even then we divide it by 2,
if it's odd just multiply by 3 and add 1 more.

After a while the sequence becomes continuous in 1,
this is why ...
And of course only numbers > 0 will work.
*/

#include <stdio.h>

int v[1000000];
int i = 0;

int makeCollatz(int n){
    if(n <= 0){
        return 0;
    }
    else if(n == 1){
        return 1;
    }
    else{
        v[i] = n;
        i++;
        if(n % 2 == 0){
            n /= 2;
        }
        else{
            n = 3 * n + 1;
        }
    }
    return makeCollatz(n);
}

int main(void){
    int number, aux;
    
    printf("Enter a number to calcule collatz: \n");
    scanf("%d", &number);
    aux = makeCollatz(number);
    if(aux == 0){
        printf("Error\n");
    }
    else if(aux == 1){
        v[i] = 1;
        i++;
    }

    printf("The collatz sequence is: \n");
    printf("%d", v[0]);
    for(int j = 1; j < i; j++){
        printf(" %d", v[j]);
    }
    printf("...\n");

    return 0;
}