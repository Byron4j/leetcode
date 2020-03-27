package org.byron4j.leetcode.primary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public class _01_TwoArrayIntersection {

    public static int[] intersect(int[] nums1, int[] nums2){
        // 存储结果的数组
        int[] resArr;
        // 存储是否被匹配过
        int[] flagArr;

        // 最后的结果的元素个数，多余的会清除
        int resCnt = 0;

        if( nums2.length > nums1.length ){
            flagArr = new int[nums2.length];
        }else{
            flagArr = new int[nums1.length];
        }

        for (int i=0; i< nums2.length; i++) {
            for (int j=0; j< nums1.length; j++) {
                if(flagArr[j] == 0){
                    // 没有被标记过才进来
                    if (nums2[i] == nums1[j]) {
                        resCnt++;
                        flagArr[j] = 1; // 记录标记，表示里层遍历的下表为j的已经被匹配过了
                        break; // 匹配到则下一个
                    }
                }
            }
        }
        resArr = new int[resCnt];
        int idx = 0;
        for (int i = 0; i < flagArr.length; i++) {
            if( flagArr[i] == 1 ){
                resArr[idx] = nums1[i];
                idx++;
            }
        }

        return resArr;

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
