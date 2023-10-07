package com.pratice.dsa.arrays;

public class MaxProduct {

    public static void main(String[] args) {

        //int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = new int[]{2,3,-2,4};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {

        if(nums.length==1) return nums[0];
        int max = Integer.MIN_VALUE;
        int sum = nums[0];

        for (int val = 1; val < nums.length; val++) {

//            if (nums[val] < 0 && val + 1 < nums.length && nums[val + 1] < 0 && max < 0) {
//                sum = -1;
//            }

            sum *= nums[val];
            max = Math.max(sum, max);

            if (sum < 1) sum = 1;

        }
        return max;


    }
}
