package com.pratice.dsa.recurssion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetWithDuplicate {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2}));
    }

    private static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
         backtrack(list, new ArrayList<>(), nums, 0);
return list;
    }

    private static void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        List<Integer> checkList = new ArrayList<>(tempList);
        Collections.reverse(checkList);
        if (!list.contains(tempList) && !list.contains(checkList)) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
//            if(!tempList.contains(nums[i])) { // This can be added if elements within must not be duplicate.
                tempList.add(nums[i]);
//            }
            backtrack(list, tempList, nums, i + 1);
            if(tempList.size()>0) {
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
