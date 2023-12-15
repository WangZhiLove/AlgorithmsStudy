package com.algorithms.wz.data.structure.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">206. 反转链表</a>
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedList {

    /**
     * 老相识了，来试试看
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode virtual = new ListNode(0);
        while (head != null) {
            // 先保留当前节点
            ListNode virtualNode = head;
            // 更换头指针
            head = head.next;
            // 更换虚拟节点的下个节点
            virtualNode.next = virtual.next;
            // 维护外围虚拟节点
            virtual.next = virtualNode;
        }
        return virtual.next;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode first = new ListNode(1);
        head.next = first;
        ListNode second = new ListNode(2);
        first.next = second;
        ListNode three = new ListNode(3);
        second.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode listNode = reverseList2(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
