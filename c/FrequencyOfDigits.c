#include <stdio.h>

int main()
{
    int n, count = 0, i, a[count], r, n1, c1 = 0, k, l;
    printf("Enter the number : ");
    scanf("%d", &n);
    n1 = n;
    // Count the number of digits
    while (n != 0)
    {
        n /= 10;
        count++;
    }
    n = n1;
    // Store the value of digits in an array
    for (i = 0; i < count; i++)
    {
        r = n % 10;
        a[i] = r;
        n /= 10;
    }
    // Traversing through the digits and updating the count
    for (k = 0; k < count; k++)
    {
        for (l = 0; l < count; l++)
        {
            if (a[k] == a[l])
                c1++;
        }
        printf("Frequency of %d : %d\n", a[k], c1);
        c1 = 0;
    }
    return 0;
}
