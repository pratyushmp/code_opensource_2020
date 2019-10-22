import java.util.Arrays;
public class Bubblesort{

    public static void main(String[] args) {
        int A[] = {9, 5, 4, 2, 1, 8, 7, 6};
        for(int i = 0; i < A.length; i++){
            for(int j= 1; j < A.length; j++){
                if(A[j-1]> A[j]){
                    swap(A, j-1, j);
                }
            }
            System.out.println(Arrays.toString(A));
        }
    }

    public static void swap(int A[],int i,int m){
        int t = A[i];
        A[i] = A[m];
        A[m] = t;
        System.out.println(Arrays.toString(A));
    }
}