package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/description/">93.复原IP地址</a>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 */
public class RestoreIpAddresses {

    List<String> result = new ArrayList<>();

    List<String> temp = new ArrayList<>();

    int[][] flag;

    /**
     * 和之前的回文子串有点类似，还是需要注意当前循环如何做，
     *
     * @param s 给定的字符串
     * @return 所有符合要求的
     */
    public List<String> restoreIpAddresses(String s) {
        flag = new int[s.length()][s.length()];
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int index) {
        if (temp.size() == 4 && index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                if (i != temp.size() - 1) {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
            return;
        } else if (temp.size() < 4) {
            for (int i = index; i < s.length(); i++) {
                if (isIP(s, index, i) == 1) {
                    temp.add(s.substring(index, i + 1));
                    backtracking(s, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private int isIP(String s, int left, int right) {
        if (flag[left][right] != 0) {
            return flag[left][right];
        }
        String ip = s.substring(left, right + 1);
        if (ip.length() > 1 && ip.startsWith("0")) {
            flag[left][right] = -1;
            return -1;
        }
        if (ip.length() > 3 || (ip.length() == 3 && Integer.valueOf(ip) > 255)) {
            flag[left][right] = -1;
            return -1;
        }
        flag[left][right] = 1;
        return 1;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("101023");
        strings.forEach(System.out::println);
    }
}
