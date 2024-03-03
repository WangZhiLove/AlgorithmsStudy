package com.algorithms.wz.one.day.year24.month3;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description">225.用队列实现栈</a>
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

/**
 * 使用队列实现栈，队列的特性是先进先出，FIFO，栈的特性是先进后出，FILO
 * 这里可使用双端队列，在 Java 中，双端队列的实现是 LinkedList
 * <p>
 * 如果使用一个队列如何实现？一个队列可以在插入的时候做做思考，插入的时候先把当前元素入队，然后遍历之前的元素，将元素出对放在后面就可以
 * 如下：
 * public void push(int x) {
 *      int n = queue.size();
 *      queue.offer(x);
 *      for (int i = 0; i < n; i++) {
 *      queue.offer(queue.poll());
 *  }
 * }
 */
class MyStack {

    private LinkedList<Integer> myDeque = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        myDeque.add(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        Integer last = myDeque.peekLast();
        myDeque.removeLast();
        return last;
    }

    public int top() {
        return myDeque.getLast();
    }

    public boolean empty() {
        return myDeque.isEmpty();
    }
}
