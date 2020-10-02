
public class SmallestNumber {
    //        Given a list of integers what's the smallest integer
    //        not in the list that is also not the result of the addition of 2 or more number in the list
    //        Test case. [1,2,2,5,7] ans=18. [1,2,5,7] ans=4

    public static void main(String args[]) {
        int array1[] = {1,2,2,5,7};
        int array2[] = {1,2,5,7};

        findTheSmallestInteger(array1, array1.length);
        findTheSmallestInteger(array2, array2.length);

    }

    public static void findTheSmallestInteger(int arr[], int n)
    {
        int smallestNumber = 1;

        for (int i = 0; i < n && smallestNumber >= arr[i]; i++) {
            smallestNumber = smallestNumber + arr[i];
        }

        System.out.println("Smallest int is : " + smallestNumber);
    }
}
