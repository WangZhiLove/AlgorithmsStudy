package com.algorithms.wz.data.structure.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/">203. 移除链表元素</a>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveLinkedListElements {

    /**
     * 移除元素，注意头节点的移除
     *
     * @param head 头节点
     * @param val  目标值
     * @return 移除元素后的头节点
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 考虑头部是目标元素，先去除头部是目标元素
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode result = head;
        while (result != null) {
            while (result.next != null && result.next.val == val) {
                result.next = result.next.next;
            }
            result = result.next;
        }
        return head;
    }

    /**
     * 构造虚拟节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        // 构造虚拟节点
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode temp = virtual;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return virtual.next;
    }

    /**
     * 递归的思路
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 相当于遍历了一遍链表
        head.next =  removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        head.next = first;
        ListNode second = new ListNode(6);
        first.next = second;
        ListNode three = new ListNode(3);
        second.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        removeElements3(head, 6);
    }
}
