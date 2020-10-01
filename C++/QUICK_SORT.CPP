#include<iostream.h>
int arr[200];
void swap(int &m,int &n){

   int temp=m;
   m=n;
   n=temp;}

int divide(int start,int end)
{
int cnt=start,j=start;
   int pivot=arr[end];


   while(j<(end)){

     if(arr[j]<=pivot){
	swap(arr[j],arr[cnt]);
       cnt++;
       j++;
       }
else
{
   j++;
}
}
swap(arr[cnt],arr[end]);

return cnt;
}



void quicksort(int start,int end){

   if(start>=end){}
   else{

      int m=divide(start,end);
      quicksort(start,m-1);
      quicksort(m+1,end);
      }}

      void main()
      {

	int n,i=0,p=0;
	cin>>n;



	while(i<n){
	  cin>>arr[i];  i++;}

	  quicksort(0,n-1);
	   while(p<n){
	    cout<<arr[p];   p++;}
	    }
