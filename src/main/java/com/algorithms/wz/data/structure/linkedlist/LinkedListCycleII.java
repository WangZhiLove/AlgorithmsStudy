package com.algorithms.wz.data.structure.linkedlist;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">142.环形链表II </a>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class LinkedListCycleII {

    /**
     * 使用 Map 来进行遍历查找
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode virtual = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while (virtual != null) {
            if (map.get(virtual) != null) {
                return virtual;
            }
            map.put(virtual, index ++);
            virtual = virtual.next;
        }
        return null;
    }

    /**
     * 快慢指针找到环，再根据数学计算得出找环头节点的规律
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
