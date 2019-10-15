#include<stdio.h>
void accept(int [5][5],int ,int);
 void multiply(int *,int *,int ,int ,int);
int main()
{
    int row1,col,col2;
    int a[5][5],b[5][5]  
    printf("enter the row and col of the first matrix\n");
    scanf("%d %d",&row1,&col);
    printf("enter the columns ofnthe second matrix");
    scanf("%d",&col2);
     accept (a,row1,col,);
     accept(b,col,col2);
     multiply(a,b,row1,col,col2);
}
void accept(int a [5][5],int row ,int col)
{
    for(int i=0;i<row;i++)
    {
        for (int j=0;j<col;j++)
        {
            scanf("\n%d",&a[i][j]);
            printf("\n%d",a[i][j]);
        }
    }
}
void multiply(int *a,int *b,int row ,int col ,int col2)
{ 
    int mul[5][5];
    for( int i=0;i<row;i++)
    {
        for(int j=0;j<col2;j++ )
        int sum =0
        {
            for( int k=0;k<col;k++)
            {
               sum+= *(*(a+i*5)+k) * *(*(b+k*5)+j); 
            }
            mul[i][j]=sum;
            printf("%d",mul[i][j]);
        }
    }

}