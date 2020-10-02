#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int maxseats=9,maxmovies=4;
struct movies
{
 char mname[100];
 float tprice;
 int availseats[4],hallno,status;
};
struct date
{
 int day,mnth,yr;
};
struct emp
{
 char name[20], add[100], empid[5], design[10], flag;
 struct date dob,doj;
 float salary;
};
typedef struct movies movies;
typedef struct emp emp;
void insertmovie()
{
 FILE *fp;
  int i;
  fp=fopen("MOVIES.DAT","ab+");
  movies m;
  fflush(stdin);
  printf("*********************************************");
  printf("\nEnter the details of the movie - ");
  printf("\n\tName - ");
  gets(m.mname);
  fflush(stdin);
  printf("\n\tPrice per Ticket - ");
  scanf("%f",&m.tprice);
  printf("\n\tHall number - ");
  scanf("%d",&m.hallno);
  for(i=0;i<4;++i)
  m.availseats[i]=maxseats;
  m.status=1;
  fwrite(&m,sizeof(m),1,fp);
  fclose(fp);
}
void deletemovie()
{
 FILE *fp;
 fp=fopen("MOVIES.DAT","rb+");
 movies m;
 int flag=0;
 char name[100];
 printf("Enter the name of the movie to be deleted.\t");
 fflush(stdin);
 gets(name);
 while(fread(&m,sizeof(movies),1,fp)==1)
 {
  if(strcmp(m.mname,name)==0)
   {
    m.status=0;
    ++flag;
    printf("\nThe movie you selected has been removed.");
   }
 }
 if(flag==0)
  printf("\nNo such movie found.");
  fseek(fp,-1*sizeof(m),SEEK_CUR);
   fwrite(&m,sizeof(m),1,fp);
 fclose(fp);
}
int display()
{
 movies m;
 int flag,i=1;
 FILE *fp;
 fp=fopen("MOVIES.DAT","rb");
 while(fread(&m,sizeof(movies),1,fp)==1)
 {
  if(m.status==1)
  {
   printf("\n-------------------------------------------------------");
   printf("\n%d. %s\t-\tRs. %6.1f\tin Hall no - %d",i++,m.mname,m.tprice,m.hallno);
   flag=1;
  }
 }
 if(flag!=1)
    {
    printf("\n\tNo Movies stored yet.");
    return 0;
    }
 else
    printf("\n-------------------------------------------------------");
 fclose(fp);
 return 1;
}
//function for storing the movie data
void storemovie()
{
 printf("\t\tMovie Records Management Portal");
 printf("\nThis is to manage the movies stored in the record file");
 int opt,x;
 do{
  printf("Select your action - \n\t1. Insert into movie's stack.\n\t2. Delete from movie's stack\n\t3. Display all movies currently stored\n\t4. Delete the movies file\n\t5. Go to main page\n\t");
  scanf("%d",&opt);
  switch(opt)
  {
   case 1: insertmovie();
           break;
   case 2: deletemovie();
           break;
   case 3: x=display();
           break;
   case 4: printf("Enter password - ");
           FILE *fp;
           char str[9];
           scanf("%s",str);
           //password = jiitece
           if(strcmp(str,"jiitece")!=0)
            {
                printf("\nWRONG PASSWORD ");
                break;
            }
           fclose(fopen("MOVIES.DAT","w"));
           printf("\nFile is deleted.....");
           break;
   case 5: printf("\n\t--------------------------THANK YOU--------------------------------");
           break;
   default: printf("\n\tSorry couldn't get you");
  }
  printf("\nEnter any key to continue........");
  system("pause");
  system("cls");
 }while(opt!=5);
}
void selectmovie()
{
 printf("\t\tMovie Selection Portal");
 printf("\nThank you for selecting us.");
 movies m;
 char name[100];
 int flag=0,paid,i,num,slot;
 printf("\nEnter the movie from the list below (Enter the full name)- ");
 int x=display();
 if(x==0)
    return;
 fflush(stdin);
 printf("\n");
 gets(name);
 printf("\nEnter number of seats required -  ");
 scanf("%d",&num);
 FILE *fp;
 fp=fopen("MOVIES.DAT","rb+");
 while(fread(&m,sizeof(movies),1,fp)==1)
 {
  if(strcmp(name,m.mname)==0)
    break;
 }
 printf("\nHall no.- %d",m.hallno);
 printf("\nTime slots -\n\t 9:30 - 12:30 -> Slot 1\n\t 1:30 -  4:30 -> Slot 2\n\t 5:30 -  8:30 -> Slot 3\n\t 9:30 - 12:30 -> Slot 4\n\n");
 for(i=0;i<4;++i)
 {
  if(m.availseats[i]>0 && num<=m.availseats[i])
    printf("\nTime slot %d\t:\tSeats Available - %d",i+1,m.availseats[i]);
    ++flag;
 }
 printf("\n\nEnter your preferred time slot - ");
 scanf("%d",&slot);
 if(flag)
 {
  printf("Pay Rs.%6.1f.\n(If customer has paid enter 1 otherwise enter 0.)\t",m.tprice*num);
  scanf("%d",&paid);
  if(paid)
   m.availseats[slot-1]-=num;
 }
 else
  printf("Sorry the movie is HOUSEFULL for all slots today.");
fseek(fp,-1*sizeof(m),SEEK_CUR);
fwrite(&m,sizeof(m),1,fp);
fclose(fp);
printf("\n\n----------------------------- THANK YOU ---------------------------");
printf("\n\nEnter any key to go back to menu.......");
system("pause");
system("cls");
}
void edisplay()
{
 int x=0;
 emp node;
 FILE *fp;
 fp=fopen("EMPLOYEE.DAT","rb");
 if(fp==NULL)
 {
     printf("\t\tFile isn't opening !!!!!!!!!");
     goto l;
 }
 while(fread(&node,sizeof(emp),1,fp)==1)
 {
  if(node.flag!='r')
  {
   printf("\n*******************************************************");
   printf("\n\t Employee ID - %s",node.empid);
   printf("\n\t Name - %s",node.name);
   printf("\n\t Salary - Rs %6.1f",node.salary);
   printf("\n\t Designation - %s",node.design);
   printf("\n\t Date of Birth - %d %d %d",node.dob.day,node.dob.mnth,node.dob.yr);
   printf("\n\t Date of Joining - %d %d %d",node.doj.day,node.doj.mnth,node.doj.yr);
   printf("\n\t Address - %s\n",node.add);
   ++x;
  }
 }
 if(x==0)
 printf("\t\tFile is empty!\n");
 l:
 fclose(fp);
}
void update()
{
 char id[5],ans;
 int flag=0,choice;
 emp node;
 FILE *fp;
 fp=fopen("EMPLOYEE.DAT","rb+");
 printf("Enter ID of the employee whose details need to be updated - \n");
 fflush(stdin);
 scanf("%s",id);
 while(fread(&node,sizeof(emp),1,fp)==1)
 {
  if(strcmp(node.empid,id)==0 && node.flag=='e')
  {
   printf("FOUNDED EMPLOYEE ID - %s (%s)",node.empid,node.name);
   do{
      printf("\nSelect what to be updated - 1.Name 2.Address 3.Designation 4.Salary    ");
      scanf("%d",&choice);
      fflush(stdin);
      switch(choice)
      {
	case 1: printf("\nEnter Name - ");
		    gets(node.name);
		    break;
	case 2: printf("\nEnter Address - ");
		    gets(node.add);
		    break;
	case 3: printf("\nEnter Designation - ");
		    scanf("%s",node.design);
            break;
	case 4: printf("\nEnter Salary - ");
		    scanf("%f",&node.salary);
       }
       fflush(stdin);
       printf("Do you want to update another field for this employee? (Yes-y,No-n)");
       scanf("%c",&ans);
      }while(ans=='y'||ans=='Y');
   flag=1;
   fseek(fp,-1*sizeof(emp),SEEK_CUR);
   fwrite(&node,sizeof(emp),1,fp);
   break;
  }
 }
 if(flag==0)
 printf("No such employee currently employed");
 fclose(fp);
}
void enter_employee()
{
 emp node;
 FILE *fp;
 fp=fopen("EMPLOYEE.DAT","ab");
 printf("\n\t Enter Employee ID - ");
 scanf("%s",node.empid);
 fflush(stdin);
 printf("\n\t Enter Name - ");
 gets(node.name);
 fflush(stdin);
 printf("\n\t Enter Address - ");
 gets(node.add);
 printf("\n\t Enter Designation - ");
 scanf("%s",node.design);
 fflush(stdin);
 printf("\n\t Enter Date of Birth - ");
 printf("\n\t\tDay - ");
 scanf("%d",&node.dob.day);
 printf("\n\t\tMonth - ");
 scanf("%d",&node.dob.mnth);
 printf("\n\t\tYear - ");
 scanf("%d",&node.dob.yr);
 fflush(stdin);
 printf("\n\t Enter Date of joining - ");
 printf("\n\t\tDay - ");
 scanf("%d",&node.doj.day);
 printf("\n\t\tMonth - ");
 scanf("%d",&node.doj.mnth);
 printf("\n\t\tYear - ");
 scanf("%d",&node.doj.yr);
 fflush(stdin);
 printf("\n\t Enter Current Salary - ");
 scanf("%f",&node.salary);
 node.flag='e';
 fwrite(&node,sizeof(node),1,fp);
 fclose(fp);
}
void remove_employee()
{
 emp node;
 char id[10],flag2='x';
 FILE *fp;
 fp=fopen("EMPLOYEE.DAT","rb+");
 printf("Enter ID of the employee whose details need to be updated - ");
 fflush(stdin);
 scanf("%s",id);
 while(fread(&node,sizeof(emp),1,fp)==1)
 {
  if(strcmp(node.empid,id)==0)
    {
        node.flag='r';
        flag2='a';

    }
 }
 if(flag2=='x')
    printf("This Employee ID does not exists");
 else
 {fseek(fp,-1*sizeof(node),SEEK_CUR);
  fwrite(&node,sizeof(node),1,fp);
  printf("Removed Employee - %s (%s)",id,node.name);
 }
 fclose(fp);
}

void cover()
{
 char passcode[6],pass[8];
 printf("Enter password - ");
 scanf("%s",passcode);

 if(strcmp(passcode,"jiitece")!=0)
 {
  printf("INCORRECT PASSWORD");
  return;
 }
 else
 {
  printf("\t\t Employee Record Managing Portal");
  printf("\nThis Page is for the management of those working in the Cinema Hall.\n");
  int choice;
  char ans;
  do{
     printf("\t\t Employee Record Managing Portal");
     printf("\n What operation do you need? (choose the index)  ");
     printf("\n\t1.Display\n\t2.Update\n\t3.Add Employee\n\t4.Remove Employee\n\t5.Go to main page\n\t6.Delete the whole file (encrypted)\n\t");
     scanf("%d",&choice);
     switch(choice)
     {
      case 1: edisplay();
       	      break;
      case 2: update();
              break;
      case 3: enter_employee();
	          break;
      case 4: remove_employee();
              break;
      case 5: printf("\n\n\t\t\t\tTHANK YOU");
	          break;
      case 6: printf("Enter confirmation password - ");
              scanf("%s",pass);
              if(strcmp(pass,"jiitece")==0);
              FILE *f;
              fclose(fopen("EMPLOYEE.DAT","w"));
              printf("...............The File is deleted ...................");
              choice=5;
              break;
     }
     fflush(stdin);
     printf("\n\nPress any key to continue................. ");
     system("pause");
     system("cls");
  }while(choice!=5);

 }
}
int main()
{
    int opt;
    printf("*******************************************************************************************************************\n\n\n\n");
    printf("                                             P.V.R. Cinema Hall\n\n\n");
    printf("*******************************************************************************************************************");
    system("pause");
    system("cls");
    do
    {
        printf("\t\tWELCOME TO P.V.R. Cinema Hall\n\t Main Page ");
        printf("\n\nEnter the index corresponding to required page.");
        printf("\n\t1. Movie Selection Portal\n\t2. Movie Record Keeping Portal\n\t3. Employee Record Keeping Portal\n\t4. Exit\n\t");
        scanf("%d",&opt);
        fflush(stdin);
        system("cls");
        switch(opt)
        {
            case 1: selectmovie();
                    break;
            case 2: storemovie();
                    break;
            case 3: cover();
                    break;
            case 4: printf("\n\n..................................THANK YOU...........................................\n\n");
                    break;
            default: printf("Sorry couldn't get you...");
        }
        printf("\n\n\nEnter any key to continue....");
        system("pause");
        system("cls");
    }while(opt!=4);
    printf("\n********************************************************\n\t\tSaiyonara. Hope to see you again\n********************************************************");
    return 0;
}
