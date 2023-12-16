package com.algorithms.wz.data.structure.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/">19.删除链表的倒数第N个节点</a>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 暴力方法破解，先循环一遍，获取元素的个数，然后循环第二遍的时候进行删除
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int size = 0;
        ListNode virtual = head;
        // 计算元素的个数
        while (virtual != null) {
            size++;
            virtual = virtual.next;
        }
        // 移除元素，使用虚拟节点，都在如果删除头节点，无法删除
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        virtual = virtualHead;
        // 正向第 n 个元素，索引从 1 开始
        int len = size - n + 1;
        int index = 1;
        // 遍历到删除元素的前一个元素
        while (index < len) {
            index++;
            virtual = virtual.next;
        }
        // 删除元素
        virtual.next = virtual.next.next;
        return virtualHead.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode three = new ListNode(3);
        second.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode listNode = removeNthFromEnd2(first, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 递归思路
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;
        myRemoveNthFromEnd(virtualHead, n);
        return virtualHead.next;
    }

    private static int myRemoveNthFromEnd(ListNode virtualHead, int n) {
        if (virtualHead.next == null) {
            return 1;
        }
        int result = myRemoveNthFromEnd(virtualHead.next, n);
        if (result == n) {
            virtualHead.next = virtualHead.next.next;
        }
        return result + 1;
    }

}
