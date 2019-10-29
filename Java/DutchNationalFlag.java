package AlgorithmsAndDS;

public class DutchNationalFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1, 1, 2, 1 };
		
		sortDNF(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
	}

	public static void sortDNF(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr,mid,low);
				low++;
				mid++;
			}
			else if (arr[mid] == 1) {
				mid++;
			}
			else if(arr[mid]==2) {
				swap(arr,mid,high);
				high--;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.err.print(arr[i] + " ");
		}
	}

}
