#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<time.h>
struct node
{
    int data;
    struct node *next;
}*common=NULL;
struct node *insert(struct node *newn,struct node *header){
    struct node *ptr;
    if(header==NULL){
        header=newn;
        return header;
    }
    ptr=header;
    while (ptr->next!=NULL)
    {
        ptr=ptr->next;
    }
    ptr->next=newn;
    return header;
}
int check_for_loop(struct node *header){
    struct node *tortoise,*hare;
    hare=tortoise=header;
    while(hare!=NULL&&hare->next!=NULL){
        hare=hare->next->next;
        tortoise=tortoise->next;
        if(hare==tortoise){
            common=hare;
            return 1;
        }
    }
    return 0;
}
int length_of_loop(){
    struct node *p;
    int count=0;
    p=common;
    while(p->next!=common){
        count++;
        p=p->next;
    }
    return count;
}
int main()
{
    srand(time(0));
    int n,i=0,k;
    struct node **arr;
    struct node *newn,*header=NULL,*tailor=NULL;
    printf("\nFirstly Creating the linked list\n");
    printf("\nEnter the number of nodes : ");
    scanf("%d",&n);
    arr=(struct node**)malloc(n*sizeof(struct node));
    while(i<n)
    {
        newn=(struct node*)malloc(sizeof(struct node));
        printf("\nEnter data : ");
        arr[i++]=newn;
        scanf("%d",&newn->data);
        newn->next=NULL;
        tailor=newn;
        header=insert(newn,header);
    }
    int random=rand()%7;
    printf("\n%d\n",random);
    if(random>=2&&random<=4)
        tailor->next=NULL;
    else
        tailor->next=arr[rand()%i];
    printf("\nCreation of Linked List successful which may have a loop or may not have one\n");
    int check_loop=check_for_loop(header);
    if(check_loop==1){
        printf("\nThere is loop in the linked list\n");
        printf("\nThe number of nodes in the loop is : %d\n\n",length_of_loop()+1);
    }
    else
    {
        printf("\nThere are no loops in the linked list\n");
        printf("\nHence length of the loop is 0\n");
    }
    printf("\nPress Any Key to stop the Execution\n");
    getch();
}