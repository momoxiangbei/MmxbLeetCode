package com.mmxb.lib.array;

/**
 * Created by mmxb on 5/20/21.
 * <p>
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String input = "ac";
        System.out.println(longestPalindrome(input));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = getSubLength(s, i, i);
            int length2 = getSubLength(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - (length - 1) / 2;     // note2 奇偶数不同是通过 (length - 1) / 2 计算出的
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);  // substring 左闭右开区间
    }

    /**
     * 中心扩散法
     */
    public static int getSubLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        // note1 left为-1时没有关系 : s= abad  left=1 right =1 =>  left=-1 right=3  result 3
        return right - left - 1;   //
    }
}
