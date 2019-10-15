package com.jagjit.Hactoberfest;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 */
public class MaximumSumSubArray {

	public static int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (sum < 0)
				sum = A[i];
			else
				sum += A[i];
			if (sum > max)
				max = sum;
		}
		return max;
	}

	public static void main(String[] args) {

		int a[] = { -2,1,-3,4,-1,2,1,-5,4 };

		int max_sum = maxSubArray(a);

		System.out.println("Maximum contiguous sum is " + max_sum);

	}

}
