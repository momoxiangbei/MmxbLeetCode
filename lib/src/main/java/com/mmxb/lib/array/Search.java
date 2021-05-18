package com.mmxb.lib.array;

/**
 * Created by mmxb on 5/18/21.
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class Search {

    public static void main(String[] args) {
        int[] array = {-1, 0, 3, 5, 9, 12};
        System.out.println(search2(array, 9));
    }

    /**
     * 二分法
     * 二分法的使用条件：1、有序数组 2、数组中无重复元素，如果有重复元素则下标可能不唯一
     * <p>
     * 难点：index = left + (right - left) / 2   如果right到left的闭区间为偶数个，则index会向左偏一个，所以也要验证下index+1 ，并且left = index + 1，并且while区间是left < right
     * 技巧：可以使用最小区间进行验证 比如 {0,1} 1
     */
    public static int search2(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int index = left + (right - left) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index + 1] == target) {
                return index + 1;
            } else if (nums[index] > target) {
                right = index;
            } else if (nums[index] < target) {
                left = index + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
