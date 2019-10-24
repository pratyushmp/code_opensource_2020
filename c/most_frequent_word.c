/* not really proud of this product of code, it is really simple
 and not really efficient (too many loops). */


#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX_WORD_LENGTH 50
int main(){
	char **str;
	int i,j,temp,N,M,max;
	int *res;
	/* memory allocation */
	printf("Usage:\nThis program prints the word with the highest frequency in a text\ngiven the number of all words in the text.\nSo for example you give N , then type the text\nYou can use redirection as \" ./a.out < file \" in the form of \nN(number of words) Text goes here\n");
	printf("How many words does this text have?\n");
	scanf("%d",&N);
	str=(char**)malloc(N*sizeof(char*));
	if(str==NULL){
		printf("No memory available\n");
		return 0;
	}
	M=MAX_WORD_LENGTH;
	printf("Please provide the text \n");
	for(i=0;i<N;i++){
		str[i]=(char*)malloc(M*sizeof(char));
		if(str[i]==NULL){
			printf("Cannot allocate row[%d]\n",i);
			return 0;
		}
	}
	res=(int *)malloc(N*sizeof(int));
	if (res==NULL){
		printf("No memory available \n");
		return 0;
	}
	/* reading the text and initialize result with 0 */
	for(i=0;i<N;i++){
		scanf("%s",&str[i][0]);
		res[i]=0;
	}
	/* count the frequency of each word */
	for(j=0;j<N;j++){
		for(i=0;i<N;i++){
			if(strcmp(str[j]+0,str[i]+0)==0){
				res[j]=res[j]+1;
			}
		}
	}
	/* finds the word with the highest frequency, if 2 or more have the same, we keep the first */
	max=res[0];
	temp=0;
	for(i=0;i<N;i++){
		if(res[i]>max){
			max=res[i];
			temp=i;
		}
	}
	printf(" \"%s\"  has the highest frequency: %d \n", str[temp]+0, res[temp]);
	for(i=0;i<N;i++){
		free(str[i]);
	}
	free(str);
	return 0;
}
	
