package com.algorithms.wz.data.structure.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/">1047. 删除字符串中的所有相邻重复项</a>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.empty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }


}
