// package SuperDream.Arrays;
import java.util.Scanner;
import java.util.Arrays;
public class MinimumPlatforms {
     public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int tc =sc.nextInt();
        for(int k=0;k<tc;k++){
        int n =sc.nextInt();
        int arr[] =new int[n];
        int dep[] = new int[n] ;
        // int i=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            // i++;
            // n--;
        }
        // int j=0;
        for(int j=0;j<n;j++){
            dep[j]=sc.nextInt();
            // j++;
        
        }
        System.out.println(minNoplatforms(arr,dep,n));
        Arrays.sort(arr);
        Arrays.sort(dep);
        

    }
    }

    public static int minNoplatforms(int[] arr, int[] dep, int n) {
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        // Similar to merge in merge sort to process 
        // all events in sorted order 
        while (i < n && j < n) { 
            // If next event in sorted order is arrival, 
            // increment count of platforms needed 
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            } 
  
            // Else decrement count of platforms needed 
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 
  
            // Update result if needed 
            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        return result; 
       
    }
}