package com.mmxb.leetcode;

import java.util.HashMap;

/**
 * Created by wangxueying on 12/15/20.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring2("abcdaaaabcdefa");
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {  //
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 1;
        String resultTempString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                resultTempString = s.substring(i, j);  //
                if (resultTempString.contains(s.charAt(j) + "")) {
                    break;
                }
                resultTempString = s.substring(i, j + 1);
                if (result < resultTempString.length()) {
                    result = resultTempString.length();
                }
            }
        }
        return result;
    }


    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        // 移动终点位置
        for (int left = 0, end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            // 当已经包含终点字母时，移动起点位置置终点字母首次出现的位置的下一位
            if (map.containsKey(endChar)) {
                // left只向后移动，不受之前重复的字符串的影响
                left = Math.max(left, map.get(endChar) + 1);
            }
            // 刷新终点字母的位置，为下一次遇到重复字符串起点移动做准备
            map.put(endChar, end);
            // 刷新最大的不重复字段的长度
            max = Math.max(max, end - left + 1);
        }
        return max;
    }
}







