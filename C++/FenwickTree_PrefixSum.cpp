#include<iostream>
#include<cmath>
#include<vector>
#include<climits>
#include<algorithm>
#include<cassert>
using namespace std;

// BIT / Fenwick tree
// can also make it for min max till n queries
// Also for inversion count

void updateBitTree(vector<int> &BitTree , int n, int p, int a)
{
	// a[i] increment at p;
	while(p<=n)
	{
	BitTree[p] += a; 	
	p += (p&(-p)) ;	
	}

return;	
}

int queryBitTree(vector<int> &BitTree , int p)
{
// 1-p; sum;	
	int ans=0;
	while(p>0)
	{
	ans+=BitTree[p];
	p -= (p&(-p));	
	}
	return ans;
}

void builtBitTree(vector<int> &BitTree , int n, vector<int> &a)
{
 for(int i=1;i<=n;i++)
 {
 updateBitTree(BitTree,n,i,a[i]);	 
 }	
 return;
}

int main()
{
int n;
cin>>n;
vector<int> BitTree(n+2,0);
vector<int> a(n+2,0);
for(int i=1;i<=n;i++)
{
cin>>a[i];	
}
builtBitTree(BitTree,n,a);
cout<<"Our Tree: "<<endl;
for(int i=1;i<=n;i++)
{
cout<<BitTree[i]<<" ";	
}
cout<<endl;
cout<<"Enter number of queries"<<endl;
int q;
cin>>q;
while(q--)
{
int ty ;
cout<<"1 for update 2 for query range"<<endl;
cin>>ty;

if(ty==1)
{
//
cout<<" value then position to update (space separated)"<<endl; 	
int x,p;
cin>>x>>p;
// x inc at p pos;
updateBitTree(BitTree,n,p,x);
}
else if(ty==2)
{
int l;
// 1-l sum
cout<<"Enter L (till where we need prefix sum)"<<endl;
cin>>l;
int d =queryBitTree(BitTree,l) ; // till l
cout<<d<<endl;	
}
	
}

return 0;
}
