import java.util.Scanner;

// package SuperDream.Arrays;

public class sort0s1s2s {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int tc= sc.nextInt();
        for(int i=0;i<tc;i++){
            int n =sc.nextInt();
            int arr[] =new int[n];
            for(int k=0;k<n;k++){
                arr[k]=sc.nextInt();
            }
            sort(arr,n);

        }
       
        // System.out.print()
        
    }

    public static void sort(int[] arr, int n) {
        int p, c1=0,c0=0,c2=0;
        for(int i=0;i<n;i++){
            switch(arr[i]){
                case 0: 
                    c0++;
                    break;
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
            }
        }
        p=0;
        while (c0>0){
            arr[p++]=0;
            c0--;
        }
        while(c1>0){
            arr[p++]=1;
            c1--;
        }
        while(c2>0){
            arr[p++]=2;
            c2--;
        }
        printArray(arr,n);
    }

    private static void printArray(int[] arr, int n) {
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}