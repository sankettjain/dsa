package com.pratice.dsa.arrays;

public class MaxSubarray {

    public static void main(String[] args) {

        int[] arr = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};
        //int[] arr = new int[]{-2, -4, -7};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }
}
