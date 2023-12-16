package com.algorithms.wz.data.structure.linkedlist;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/">面试题 02.07. 链表相交  </a>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class IntersectionOfTwoLinkedListsLcci {

    /**
     * 暴力破解，双层 for 循环
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode virtualA = headA;
        while (virtualA != null) {
            ListNode virtualB = headB;
            while (virtualB != null) {
                if (virtualB == virtualA) {
                    return virtualA;
                }
                virtualB = virtualB.next;
            }
            virtualA = virtualA.next;
        }
        return null;
    }

    /**
     * 单层循环，借助 List 结构
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode virtualA = headA;
        ListNode virtualB = headB;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (virtualA != null) {
            map.put(virtualA, virtualA.val);
            virtualA = virtualA.next;
        }
        while (virtualB != null) {
            if (map.get(virtualB) != null) {
                return virtualB;
            }
            virtualB = virtualB.next;
        }
        return null;
    }

    /**
     * 双指针，我想到可能要用到双指针，但是没想到怎么用，关键的就是双指针遍历完属于自己的链表后，下一步该怎么做，这是关键
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        boolean ab = true;
        boolean ba = true;
        while (pointA != null && pointB != null) {
            if (pointA == pointB) {
                return pointA;
            }
            pointA = pointA.next;
            pointB = pointB.next;
            if (pointA == null && ab) {
                pointA = headB;
                ab = false;
            }
            if (pointB == null && ba) {
                pointB = headA;
                ba = false;
            }
        }
        return null;
    }

}
