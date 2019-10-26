#include <stdio.h>

int main(void) {

    long long int n, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, r1, r2;
    
    //find all digits
    scanf("%ld", &n);
    d11 = n % 10;
    d10 = (n / 10) % 10;
    d9 = (n / 100) % 10;
    d8 = (n / 1000) % 10;
    d7 = (n / 10000) % 10;
    d6 = (n / 100000) % 10;
    d5 = (n / 1000000) % 10;
    d4 = (n / 10000000) % 10;
    d3 = (n / 100000000) % 10;
    d2 = (n / 1000000000) % 10;
    d1 = (n / 10000000000) % 10;
    
    //check cpf validity
    r1 = (d1*10 + d2*9 + d3*8 + d4*7 + d5*6 + d6*5 + d7*4 + d8*3 + d9*2)*10%11;
    if(r1 == 10){
        r1 = 0;
    }
    r2 = (d1*11 + d2*10 + d3*9 + d4*8 + d5*7 + d6*6 + d7*5 + d8*4 + d9*3 + d10*2)*10%11;
    if(r2 == 10){
        r2 = 0;
    }
    if(r1 == d10 && r2 == d11){
        printf("valid\n");
    }
    else{
        printf("invalid\n");
    }

    return 0;
}