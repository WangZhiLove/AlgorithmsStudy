package com.algorithms.wz.str;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 回文字符串的意思其实就是对称
 *
 * @author wangzhi
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = longestPalindrome("bb");
        System.out.println(s);
    }

    /**
     * 这道题目看上去好像挺简单，仔细思考并没有那么容易，先暴力破解看看，两层循环 + 双指针可以解决，就是时间有点久，想想还有其它的解决方案没
     *
     * @param s 字符串
     * @return 最长的回文子串
     */
    public static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                if (palindrome(s.substring(i, j))) {
                    result = result.length() < (j - i + 1) ? s.substring(i, j) : result;
                    break;
                }
            }
        }
        return "".equals(result) ? String.valueOf(s.charAt(0)) : result;
    }

    public static boolean palindrome(String s) {
        int x = 0;
        int y = s.length() - 1;
        while (x < s.length() && y >= 0 && s.charAt(x) == s.charAt(y) && x <= y) {
            x++;
            y--;
        }
        return x > y;
    }

    /**
     * 中心扩散算法，其实之前已经有点那个意思，中心扩散算法就是我之前考虑的分两种情况，奇数和偶数，也就是中心为 1 和中心为 2 的情况，每次考虑都考虑两种情况就 ok
     * 代码如下：代码简洁很多
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数情况
            int len = expandAroundCenter(s, i, i);
            // 偶数情况
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len, len2);
            if (end - start < maxLen) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩散
     *
     * @param s 字符串
     * @param left 左下标
     * @param right 右下标
     * @return 长度
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

}
