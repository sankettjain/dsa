package com.pratice.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.print(removeDuplicates(nums));
        System.out.print(removeDuplicates1(nums));


    }

    public static int removeDuplicates(int[] nums) {

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        for(int n : nums)
            if(i < 1 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> mapOfValueToIndex = new HashMap();


        for (int i = 0; i < nums.length; i++) {
            if (mapOfValueToIndex.containsKey(target-nums[i])){
                return new int[]{mapOfValueToIndex.get(target-nums[i]),i};
            }
            mapOfValueToIndex.put(nums[i],i);
        }
        return new int[]{};

    }

}
