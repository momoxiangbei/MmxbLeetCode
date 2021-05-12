package com.mmxb.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Created by wangxueying on 5/10/21.
 * <p>
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {

    /**
     * 经验：
     * [0,0,0] 记得单独验证一下
     * 三层循环会超时
     */

    public static void main(String[] args) {
//        int[] nums = new int[]{};          // []
        int[] nums = new int[]{0, 0, 0};  // [0,0,0]
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};   // [[-1,-1,2],[-1,0,1]]
//        int[] nums = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
        System.out.println(threeSum(nums).toString());
    }

//    public static List<List<Integer>> threeSum2(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);  // 排序
//        if (nums.length < 3) {
//            return result;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < input.size() - 1; j++) {
//                for (int k = j + 1; k < input.size(); k++) {
//                    if (k < kStartIndex) {
//                        continue;
//                    }
//                    if (input.get(i) + input.get(j) + input.get(k) == 0) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(input.get(i));
//                        list.add(input.get(j));
//                        list.add(input.get(k));
//                        if (!result.contains(list)) {
//                            result.add(list);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

    // 超时了
    public static List<List<Integer>> threeSum(int[] nums) {
        int bigZeroNum = Integer.MAX_VALUE;
        List<Integer> input = new ArrayList<>();
        for (int num : nums) {
            if (num >= 0 && num < bigZeroNum) {
                bigZeroNum = num;
            }
            input.add(num);
        }
        Collections.sort(input);
        int kStartIndex = input.indexOf(bigZeroNum);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; input.get(i) <= 0 && i < input.size() - 2; i++) {
            for (int j = i + 1; j < input.size() - 1; j++) {
                for (int k = j + 1; k < input.size(); k++) {
                    if (k < kStartIndex) {
                        continue;
                    }
                    if (input.get(i) + input.get(j) + input.get(k) == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(input.get(i));
                        list.add(input.get(j));
                        list.add(input.get(k));
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }
}
