import java.util.Arrays;

public class SelectionSort {

    public static int[] sort (int a[]){
        int m = 0;
        for(int i = 0; i<a.length; i++){
            m = i;
            for(int j = i+1; j<a.length;j++){
                if(a[m]>a[j]){
                    m = j;
                }
            }
            swap(a, i, m);
        }
        return a;

    }

    private static void swap(int a[],int i,int m){
        int t = a[i];
        a[i] = a[m];
        a[m] = t;
        System.out.println(Arrays.toString(A));
    }
}