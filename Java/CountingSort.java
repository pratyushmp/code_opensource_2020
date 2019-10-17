import java.util.Arrays;

public class CountingSort {

	public int[] sort(int[] A) {
		int[] Result = new int[A.length + 1];
		int[] Count = new int[A.length + 1];

		for (int i = 0; i < Count.length; i++) {
			Count[i] = 0; // put count for every element as 0
		}
		// Count[] will store the counts of each integer in the given array
		for (int i = 0; i < A.length; i++) {
			int x = Count[A[i]];
			x++;
			Count[A[i]] = x;
		}
		// • Update the Count[] so that each index will store the sum till
		// previous step. (Count[i]=Count[i] + Count[i-1]).
		// Now updated Count[] array will reflect the actual position of each
		// integer in Result[].
		for (int i = 1; i < Count.length; i++) {
			Count[i] = Count[i] + Count[i - 1];
		}
		// • Now navigate the input array taking one element at a time,
		// Count[input[i]] will tell you the index position of input[i] in
		// Result[]. When you do that, decrease the count in Count[input[i]] by
		// 1.
		for (int i = A.length - 1; i >= 0; i--) {
			int x = Count[A[i]];
			Result[x] = A[i];
			x--;
			Count[A[i]] = x;
		}
		return Result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4};
		System.out.println("Orginal Array " + Arrays.toString(input));
		CountingSort c = new CountingSort();
		int[] B = c.sort(input);
		System.out.println("Sorted Array : " + Arrays.toString(B));

	}
}