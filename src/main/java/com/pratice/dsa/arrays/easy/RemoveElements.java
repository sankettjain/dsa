package com.pratice.dsa.arrays.easy;

public class RemoveElements {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,1,3,4,4};
        System.out.println(removeElements(nums,1));
    }

    private static int removeElements(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
