package com.algorithms.wz.skills.monotone.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/description/">739. 每日温度 </a>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {

    /**
     * 先暴力破解，暴力破解就是双层 for 循环，果然没有着么容易，暴力破解直接超时，但是肯定是一个解
     * @param temperatures 温度
     * @return answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 使用单调栈，单调栈的作用就是存放已经遍历过的元素，然后用当前遍历的元素和之前遍历过的元素做对比，注意单调栈存放的是索引，而非值，那这个
     * 比较有什么作用呢？其实单调栈存放的是已经遍历过并且没有比他大的元素，这样找到比他大的就可以使用索引来进行计算了
     * @param temperatures 温度
     * @return 温度升高的变化
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // 声明单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(dailyTemperatures.dailyTemperatures2(new int[]{73,74,75,71,69,72,76,73}));
    }

}
