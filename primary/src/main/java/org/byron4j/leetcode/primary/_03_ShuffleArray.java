package org.byron4j.leetcode.primary;

import java.util.Arrays;
import java.util.Random;

public class _03_ShuffleArray {

    private static class Solution{
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if(nums.length == 0){
                return nums;
            }
            int[] copyOf = Arrays.copyOf(nums, nums.length);
            // 处理copyOf
            int nextInt = new Random().nextInt(copyOf.length);
            for (int i = 0; i < copyOf.length; i++) {
                int tmp = copyOf[i];
                copyOf[i] = copyOf[nextInt];
                copyOf[nextInt] = tmp;
            }
            return copyOf;
        }


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Solution solution = new Solution(arr);
        ;
        for (int num : solution.shuffle()) {
            System.out.print(num);
        }

    }


}
