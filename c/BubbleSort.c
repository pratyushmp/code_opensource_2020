#include <stdio.h>
int main(){
  int arr[100],n, i, j, swap;

  printf("Enter number of elements\n");
  scanf("%d", &n);

  printf("Enter %d integers\n", n);

  for (i = 0; i < n; i++)
    scanf("%d", &arr[i]);

  for (i = 0 ; i < n - 1; i++)
  {
    for (j = 0 ; j < n - i - 1; j++)
    {
      if (arr[j] > arr[j+1]) /* For decreasing order use < */
      {
        swap       = arr[j];
        arr[j]   = arr[j+1];
        arr[j+1] = swap;
      }
    }
  }

  printf("After sorting using bubble sort:\n");

  for (i = 0; i < n; i++)
     printf("%d\t", arr[i]);

  return 0;
}