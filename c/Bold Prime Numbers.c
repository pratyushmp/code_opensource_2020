#include <stdio.h>
#include <math.h>

int verificar_primo(int raiz, int n){
   
    int i=3, r=1, resto;
    
    if(n==1) {
        r=0;
    }
    else if(n!=2 && n%2==0) {
        r=0;
    }
    else{
        while(i<=raiz){
            resto=n%i;
            if(resto==0){
                r=0;
                i=n;
            }
            else
                i = i + 2;
        }
    }
    return r;
}
int dividir_10(int primo, int n){
    
    int np=0;
    
    if(primo==1)
        np= n/10;
    else{
        primo=0;
    }
    return np;
}
int main(void) {
    
    int primo=0, i, novo_primo, raiz, n, T;
    
    scanf("%d", &T);
    
    for(i=0; i<T; i++){
      scanf("%d", &n);
      
        while(n>0){
            raiz=sqrt(n);
            primo = verificar_primo(raiz, n);
            novo_primo = dividir_10(primo, n);
            if(primo==1) {
                n=novo_primo;
            }
            else {
                n=0;
            }
        } 
      
        
      if(primo==1) {
          printf("Y\n");
      }
      else {
          printf("N\n");
      }
    }
    
    return 0;
}