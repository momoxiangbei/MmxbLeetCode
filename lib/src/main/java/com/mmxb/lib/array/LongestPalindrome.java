package com.mmxb.lib.array;

/**
 * Created by mmxb on 5/20/21.
 * <p>
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String input = "abbb";
        System.out.println(longestPalindrome(input));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : String.valueOf(s.charAt(0));
        }
        String subString = "";
        for (int i = 1; i < s.length() - 1; i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                if (i + 2 == s.length() && subString.length() < 2) {
                    subString = s.substring(i, i + 2);
                    continue;
                }
                int moveNum1 = getSub2(s, i);
                if (subString.length() < moveNum1 * 2 + 2) {
                    subString = s.substring(i - moveNum1, i + 1 + moveNum1 + 1);
                }
            }
            int moveNum2 = getSub1(s, i);
            if (subString.length() < moveNum2 * 2 + 1) {
                subString = s.substring(i - moveNum2, i + moveNum2 + 1);
            }
        }
        return subString;  // substring 左闭右开区间
    }

    public static int getSub1(String s, int index) {
        int moveNum = 0;
        while (s.charAt(index - 1 - moveNum) == (s.charAt(index + 1 + moveNum))) {
            if (index - 1 - moveNum == 0 && index + 1 + moveNum == s.length() - 1) {
                moveNum++;
                break;
            }
            if (index - 1 - moveNum == 0 || index + 1 + moveNum == s.length() - 1) {
                break;
            }
            moveNum++;
        }
        return moveNum;
    }

    public static int getSub2(String s, int index) {
        int moveNum = 0;
        while (s.charAt(index - 1 - moveNum) == (s.charAt(index + 2 + moveNum))) {
            if (index - 1 + moveNum == 0 && index + 2 + moveNum == s.length() - 1) {
                moveNum++;
                break;
            }
            if (index - 1 + moveNum == 0 || index + 2 + moveNum == s.length() - 1) {
                break;
            }
            moveNum++;
        }
        return moveNum;
    }
}
