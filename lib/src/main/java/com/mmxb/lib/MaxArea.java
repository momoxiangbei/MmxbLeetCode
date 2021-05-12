package com.mmxb.lib;

/**
 * Created by wangxueying on 5/12/21.
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));
    }

    // 双指针
    public static int maxArea2(int[] height) {
        int result = 0;
        int startIndex = 0;
        int endIndex = height.length - 1;
        while (endIndex > startIndex) {
            result = Math.max(result, Math.min(height[startIndex], height[endIndex]) * (endIndex - startIndex));
            if (height[startIndex] > height[endIndex]) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return result;
    }

    // 超时了
    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }
}
