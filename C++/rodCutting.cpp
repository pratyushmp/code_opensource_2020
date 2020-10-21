#include<bits/stdc++.h>
using namespace std;

int bottomUpCutRod(int p[], int n)
{
   int r[n+1],i,j;
   r[0] = 0;
   for (j=1;j<=n;j++)
   {
       int q= INT_MIN;
       for (i=0;i<j;i++)
       {
         q = max(q, p[i] + r[j-i-1]);
       }
       r[i] = q;
   }
   return r[n];
}

int max(int a, int b)
{
    return (a > b)? a : b;
}

int main()
{
    int n,i;
    cin>>n;
    int a[n];
    for(i=0; i<n; i++)
    {
        cin>>a[i];
    }
    cout<<"Maximum Revenue "<<bottomUpCutRod(a,n);
    return 0;
}
