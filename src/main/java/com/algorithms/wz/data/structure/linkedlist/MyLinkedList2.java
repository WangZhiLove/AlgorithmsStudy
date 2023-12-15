package com.algorithms.wz.data.structure.linkedlist;

public class MyLinkedList2 {

    int size;

    ListNode header;

    public MyLinkedList2() {
        size = 0;
        header = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode temp = header;
        while (index > 0) {
            index --;
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode temp = header;
        ListNode addHeaderNode = new ListNode(val, temp);
        header = addHeaderNode;
        size ++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            ListNode addTailNode = new ListNode(val);
            ListNode temp = header;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = addTailNode;
            size ++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode addTailNode = new ListNode(val);
        // 构造虚拟节点
        ListNode virtual = new ListNode(0, header);
        ListNode temp = virtual;
        int ind = 0;
        while (ind < index) {
            ind ++;
            temp = temp.next;
        }
        addTailNode.next = temp.next;
        temp.next = addTailNode;
        size ++;
        header = virtual.next;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size --;
        // 构造虚拟节点
        ListNode virtual = new ListNode(0, header);
        ListNode temp = virtual;
        int ind = 0;
        while (ind < index) {
            ind ++;
            temp = temp.next;
        }
        if (temp.next == null) {
            header = null;
            return;
        }
        temp.next = temp.next.next;
        header = virtual.next;
    }

}


