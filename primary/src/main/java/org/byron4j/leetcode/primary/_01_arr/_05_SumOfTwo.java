package org.byron4j.leetcode.primary._01_arr;

/**
 * 两数之和
 * <pre>
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * </pre>
 */
public class _05_SumOfTwo {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = {};
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if( nums[i] == target - nums[j] ){
                    arr = new int[]{i, j};
                    System.out.println("i=" + i + ",j=" + j);
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        _05_SumOfTwo sumOfTwo = new _05_SumOfTwo();
//        int[] arr = {2, 7, 11, 15};
//        int target = 9;
//        for (int i : sumOfTwo.twoSum(arr, target)) {
//            System.out.println(i);
//        }

        int[] arr2 = {-1,-2,-3,-4,-5};
        int target2 = -8;
        for (int i : sumOfTwo.twoSum(arr2, target2 )) {
            System.out.println(i);
        }
    }
}
