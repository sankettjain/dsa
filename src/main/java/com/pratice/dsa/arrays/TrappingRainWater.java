package com.pratice.dsa.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

        //int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapEasy(arr));
    }

    public static int trap(int[] height) {
        int l = 0, r = height.length - 1, sum = 0, lMax = 0, rMax = 0;
        while (l <= r) {
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);
            //why? because, for example if the lMax is smaller, we can sure that how much water could be trapped at the left pointer position is decided by the left side.
            if (lMax < rMax) {
                sum += lMax - height[l++];
            } else {
                sum += rMax - height[r--];
            }
        }
        return sum;
    }

    public static int trapEasy(int[] a) {
        int size = a.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = a[0];

        for (int i = 1; i < size; i++) {
            left[i] = Math.max(left[i - 1], a[i]);
        }
        right[size - 1] = a[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], a[i]);
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Math.min(left[i], right[i]) - a[i];
        }
        return sum;
    }
}
