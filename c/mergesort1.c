#include <stdio.h>

void mergeSort(int a[], int p, int r, int size)
{
    int q;
    if(p < r)
    {
        q = (p + r) / 2;
        mergeSort(a, p, q, size);
        mergeSort(a, q+1, r, size);
        merge(a, p, q, r, size);
    }
}

void merge(int a[], int p, int q, int r, int size)
{
    int b[size];   
    int i, j, k;
    k = 0;
    i = p;
    j = q + 1;
    while(i <= q && j <= r)
    {
        if(a[i] < a[j])
        {
            b[k++] = a[i++];   
        }
        else
        {
            b[k++] = a[j++];
        }
    }
  
    while(i <= q)
    {
        b[k++] = a[i++];
    }
  
    while(j <= r)
    {
        b[k++] = a[j++];
    }
  
    for(i=r; i >= p; i--)
    {
        a[i] = b[--k];  
    } 
}
 
int main()
{
    int a[20],n,i;
    printf("Enter the size of array: ");
    scanf("%d",&n);
    printf("Enter the elements of array: ");
    for(i=0;i<n;i++)
       scanf("%d",&a[i]);
    mergeSort(a, 0, n-1, n);
    printf("\nSorted array: \n");
    for(i=0;i<n;i++)
       printf("%d ",a[i]);
    
    return 0;
}
