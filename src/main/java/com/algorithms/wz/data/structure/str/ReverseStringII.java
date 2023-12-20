package com.algorithms.wz.data.structure.str;

/**
 * <a href="https://leetcode.cn/problems/reverse-string-ii/description/">541. 反转字符串II</a>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStringII {

    /**
     * 还是原地解决看看，就是考虑什么时候反转，什么时候不反转
     *
     * @param s 需要反转的字符串
     * @param k 反转步长
     * @return 反转后的字符串
     */
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int loop = s.length() / (2 * k);
        int loopNum = 0;
        // 计算 2k 的反转
        while (loopNum < loop) {
            int start = loopNum * 2 * k;
            int end = start + k - 1;
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
            loopNum++;
        }
        // 计算特殊情况，2k 的余数如果小于 k，全部反转，大于 k，但转前 k 个
        int remainder = s.length() % (2 * k);
        if (remainder != 0) {
            int start = loopNum * 2 * k;
            int end = remainder > k ? start + k - 1 : s.length() - 1;
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        ReverseStringII reverseStringII = new ReverseStringII();
        String abcdefg = reverseStringII.reverseStr("abcdefg", 2);
        // dcba gfe
        System.out.println(abcdefg);
    }

    /**
     * 看了官方题解，对下面代码进行优化，在两次循环中，其实 start 都是相同的，end 不同，那就合在一起，判断 start + k 和 s.length 谁小用谁，关键是确定 start
     * 虽然效率一样，但是代码更容易理解，可读性相对于程序员来说更重要
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(start + k, s.length()) - 1;
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
        return new String(charArray);
    }
}
