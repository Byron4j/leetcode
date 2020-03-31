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
public class _02_RevolveArrayReverse {
    public void rotate(int[] nums, int k) {

        // 处理一下k值输入【用例: [-1] 、2】
        k = k % nums.length;  // 取模，保证输入的正确性（不超过数组长度）

        // 新思路分析观察特征： k后面的、k前面的
        // 1. 数组倒置——7 6 5 4 3 2 1
        reverse(nums, 0, nums.length-1);
        // 2. k之前的倒置--5 6 7
        reverse(nums, 0, k-1);
        // 3. k之后的倒置--567 1 2 3 4
        reverse(nums, k, nums.length-1);



        for (int num : nums) {
            System.out.print(num+" ");
        }

    }

    private void reverse(int[] arr, int start, int end){
        while (start < end){
            // 首尾互换
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _02_RevolveArrayReverse revolveArray = new _02_RevolveArrayReverse();
        int[] arr = {1,2,3,4,5,6,7};
        int k=3;
        revolveArray.rotate(arr, k);
    }
}
