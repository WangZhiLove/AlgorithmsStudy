package com.algorithms.wz.data.structure.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/">150. 逆波兰表达式求值</a>
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * <p>
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class EvaluateReversePolishNotation {

    /**
     * 直接使用栈结构，遇到符号，出栈两位进行计算，计算完了之后再入栈
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int pop = Integer.parseInt(stack.pop());
                int pop2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(pop + pop2));
            } else if (token.equals("-")) {
                int pop = Integer.parseInt(stack.pop());
                int pop2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(pop2 - pop));
            } else if (token.equals("*")) {
                int pop = Integer.parseInt(stack.pop());
                int pop2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(pop2 * pop));
            } else if (token.equals("/")) {
                int pop = Integer.parseInt(stack.pop());
                int pop2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(pop2 / pop));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"4","13","5","/","+"}));
    }



}
