package org.byron4j.leetcode.primary._01_arr;

import java.util.Arrays;

/**
 * 两个数组的交集
 * <pre>
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * </pre>
 */
public class _01_TwoArrayIntersectionSortVersion {

    /**
     * 先排序再比较
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2){
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0; // 控制nums1
        int j=0; // 控制nums2
        int k=0; // 控制结果集数组

        while( i<nums1.length && j< nums2.length ){
            // 比较
            if( nums1[i] > nums2[j] ){
                // 大于则nums2往后走
                j++;
            }else if(nums1[i] < nums2[j]){
                // 小于则nums1往后走
                i++;
            }else{
                // 匹配到则记录； 且nums1、nums2都往后走
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOf(nums1, k);

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersection = intersect(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }


        System.out.println("============================");
        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        int[] intersection2 = intersect(nums3, nums4);
        for (int i : intersection2) {
            System.out.println(i);
        }

        System.out.println("============================");
        int[] nums5 = {4,7,9,7,6,7};
        int[] nums6 = {5,0,0,6,1,6,2,2,4};
        int[] intersection3 = intersect(nums5, nums6);
        for (int i : intersection3) {
            System.out.println(i);
        }

        System.out.println("============================");
        int[] nums8 = {4,7,9,7,6,7};
        int[] nums7 = {5,0,0,6,1,2,2,4,6,6,6};
        int[] intersection4 = intersect(nums7, nums8);
        for (int i : intersection4) {
            System.out.println(i);
        }


    }

}
