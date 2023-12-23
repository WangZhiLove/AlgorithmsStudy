package com.algorithms.wz.data.structure.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/">20. 有效的括号</a>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class ValidParentheses {

    private static HashMap<Character, Character> map = new HashMap<>();

    {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    /**
     * 这道题目放在
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (isLeftBrackets(c)) {
                stack.add(c);
            } else {
                if (stack.empty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isLeftBrackets(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                stack.add(')');
            } else if (c == '[') {
                stack.add(']');
            } else if (c == '{') {
                stack.add('}');
            } else {
                if (stack.empty() || !stack.pop().equals(c)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
