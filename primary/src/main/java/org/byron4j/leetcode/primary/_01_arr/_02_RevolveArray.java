package org.byron4j.leetcode.primary._01_arr;

/**
 * 旋转数组
 * <pre>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * </pre>
 */
public class _02_RevolveArray {
    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int tail = nums[nums.length-1];  // 尾部
            for (int j = nums.length-1; j >0; j--) {
                // 每次移动都是每个元素向后移动一位
                nums[j] = nums[j-1]; // 后移
            }
            nums[0] = tail;  // 每一轮，尾部都成为新的首部
        }


        for (int num : nums) {
            System.out.print(num+" ");
        }

    }

    public static void main(String[] args) {
        _02_RevolveArray revolveArray = new _02_RevolveArray();
        int[] arr = {1,2,3,4,5,6,7};
        int k=3;
        revolveArray.rotate(arr, k);
    }
}
