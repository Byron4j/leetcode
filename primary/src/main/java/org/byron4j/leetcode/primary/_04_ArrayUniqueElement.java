package org.byron4j.leetcode.primary;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 只出现一次的数字
 * <pre>
 *     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * </pre>
 */
public class _04_ArrayUniqueElement {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            // 位异或：相同为0，不同为1；
            // 0与任何数异或都得到这个数
            // 数组其他的都是2个一样的元素——意味着除了目标元素之外，异或后的结果为0
            // 0再异或目标元素，就得到结果了
            a^=nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        _04_ArrayUniqueElement arrayUniqueElement = new _04_ArrayUniqueElement();
        int[] arr = {2,2,1};
        System.out.println(new ArrayList<>(
                Arrays.asList(
                        arrayUniqueElement.singleNumber(arr))));
        int[] arr2 = {4,1,2,1,2};
        System.out.println(new ArrayList<>(
                Arrays.asList(
                        arrayUniqueElement.singleNumber(arr2))));
    }
}
