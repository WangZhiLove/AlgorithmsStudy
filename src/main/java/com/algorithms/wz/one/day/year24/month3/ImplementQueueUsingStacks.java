package com.algorithms.wz.one.day.year24.month3;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks">232. 用栈实现队列</a>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class ImplementQueueUsingStacks {

}

/**
 * 昨天的是用队列实现栈，今天就变成用栈实现队列了，哈哈，我应该多想一步，明天的题目是啥呢？应该也可以数据结构有关，比如说用数组实现链表啥的，哈哈，可能是
 * 队列是先进先出，栈是先进后出，借助昨天的一个思路，我在插入的时候做点操作，让栈数据结构的顺序变成队列中的顺序就好，使用两个栈来实现
 */
class MyQueue {

    /**
     * 存储栈数据
     */
    Stack<Integer> stack = new Stack<>();

    /**
     * 辅助栈，用于改变栈结构的存储顺序
     */
    Stack<Integer> auxiliaryStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!stack.isEmpty()) {
            auxiliaryStack.push(stack.pop());
        }
        stack.push(x);
        while (!auxiliaryStack.isEmpty()) {
            stack.push(auxiliaryStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
