#include<stdio.h>
#include<stdlib.h>
#include<limits.h>



typedef struct subarray
{
    int low, high, sum;
}subarray;

subarray left, right, cross, s;




subarray max_crossing_subarray(int a[], int low, int mid, int high)
{
    int sum,i,j,leftsum,rightsum;

    sum = 0;
    leftsum = INT_MIN;
    for(i=mid; i>=low; i--)
    {
        sum = sum + a[i];
        if(sum > leftsum)
        {
            leftsum = sum;
            s.low = i;
        }

    }

    sum = 0;
    rightsum = INT_MIN;
    for(j=mid+1; j<=high; j++)
    {
        sum = sum + a[j];
        if(sum > rightsum)
        {
            rightsum = sum;
            s.high = j;
        }
    }

    s.sum = leftsum + rightsum;

    return s;
}

subarray max_subarray(int a[], int low, int high)
{
    if(low==high)
    {
        s.low = low;
        s.high = high;
        s.sum = a[low];
        return s;
    }

    else
    {
        int mid = (low+high)/2;
        left = max_subarray(a, low, mid);
        right = max_subarray(a, mid+1, high);
        cross = max_crossing_subarray(a, low, mid, high);

        if(left.sum >= right.sum  &&  left.sum >= cross.sum)
        {
            s.low = left.low;
            s.high = left.high;
            s.sum = left.sum;
        }

        else if(right.sum >= left.sum  && right.sum >= cross.sum)
        {
            s.low = right.low;
            s.high = right.high;
            s.sum = right.sum;
        }

        else
        {
            s.low = cross.low;
            s.high = cross.high;
            s.sum = cross.sum;
        }

        return s;
    }
}

void main()
{
    subarray s;
    int a[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

    int i, low=0, high=(sizeof(a)/sizeof(a[0]))-1;
    s = max_subarray(a, low, high);
    printf("~The array elements are:  ");
    for(i=low; i<=high; i++)
        printf("%d  ", a[i]);
    printf("\n\n~Maximum subarray is from index = %d to %d", s.low, s.high);
    printf("\n~Maximum subarray sum = %d", s.sum);
    printf("\n~Maximum subarray elements:  ");
    for(i=s.low; i<=s.high; i++)
        printf("%d  ", a[i]);
    printf("\n");
}
