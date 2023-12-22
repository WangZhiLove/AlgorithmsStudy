package com.algorithms.wz.data.structure.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/">225. 用队列实现栈</a>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 */
public class ImplementStackUsingQueues {

}

class MyStack {

    Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (queue.size() <= 1) {
            return queue.poll();
        }
        Integer poll = queue.poll();
        Integer result = queue.poll();
        queue.add(poll);
        while (!queue.isEmpty() && !queue.peek().equals(poll)) {
            queue.add(result);
            result = queue.poll();
        }
        return result;
    }

    public int top() {
        if (queue.size() <= 1) {
            return queue.peek();
        }
        Integer poll = queue.poll();
        Integer result = queue.poll();
        queue.add(poll);
        while (!queue.isEmpty() && !queue.peek().equals(poll)) {
            queue.add(result);
            result = queue.poll();
        }
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

