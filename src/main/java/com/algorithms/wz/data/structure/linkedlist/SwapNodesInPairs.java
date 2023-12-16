package com.algorithms.wz.data.structure.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/">24. 两两交换链表中的节点</a>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode virtual = new ListNode(0);
        if (head == null || head.next == null) {
            return head;
        } else {
            // 确定返回的头节点
            virtual.next = head.next;
        }
        // 保留第一个节点以及下一次循环的前一个节点
        ListNode pre = head;
        while (head != null && head.next != null) {
            // 保留第三个节点
            ListNode temp = head.next.next;
            // 交换节点，这个地方会形成死循环
            head.next.next = head;
            // 第一个节点指向交换后的头节点
            pre.next = head.next;
            // 当前头节点等于第三个节点
            head.next = temp;
            // pre 指向下一次循环的前一个节点
            pre = head;
            // 下一次循环的头节点就是之前的第三个节点
            head = temp;
        }
        return virtual.next;
    }

    /**
     * 递归，相对来说，递归的思路更简单
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        head.next = first;
        ListNode second = new ListNode(3);
        first.next = second;
        ListNode three = new ListNode(4);
        second.next = three;
        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
