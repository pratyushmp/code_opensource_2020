public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //int[] arr = {50, 3, 10, 7, 40, 80};
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int result = getLongestSub(arr);
        System.out.println(result);
    }

    private static int getLongestSub(int[] arr) {
        if(arr==null || arr.length==0)
            return 0;
        int[] lengthStore = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            lengthStore[i] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && lengthStore[i] < lengthStore[j] + 1)
                    lengthStore[i] = lengthStore[j] + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lengthStore.length; i++) {
            if (max < lengthStore[i])
                max = lengthStore[i];
        }
        return max;
    }
}
