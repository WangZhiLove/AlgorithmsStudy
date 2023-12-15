package com.algorithms.wz.data.structure.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/design-linked-list/description/">707. 设计链表</a>
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * <p>
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * <p>
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * <p>
 * 实现 MyLinkedList 类：
 * <p>
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */
public class MyLinkedList {

    private int val;

    private MyLinkedList next;

    private int length;

    public MyLinkedList() {
        length = 0;
    }

    public MyLinkedList(int val, int length) {
        this.val = val;
        this.length = length;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        MyLinkedList virtual = virtualNode();
        MyLinkedList header = virtual.next;
        int ind = 0;
        while (ind < index) {
            ind++;
            header = header.next;
        }
        return header.val;
    }

    public void addAtHead(int val) {
        if (length != 0) {
            MyLinkedList temp = new MyLinkedList(this.val, length);
            temp.next = next;
            next = temp;
        }
        length++;
        this.val = val;
    }

    public void addAtTail(int val) {
        if (length != 0) {
            MyLinkedList temp = new MyLinkedList(val, 1);
            temp.next = null;
            MyLinkedList virtual = next;
            if (virtual == null) {
                next = temp;
            } else {
                while (virtual.next != null) {
                    virtual.length++;
                    virtual = virtual.next;
                }
                virtual.next = temp;
                virtual.length++;
            }
        } else {
            this.val = val;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            // 构造添加的节点
            MyLinkedList temp = new MyLinkedList(val, 1);
            // 构造虚拟节点，虚拟节点的 next 为当前节点
            MyLinkedList virtual = virtualNode();
            MyLinkedList virtualHeader = virtual.next;
            int ind = 0;
            // 到目标索引的前一位
            while (ind < index - 1) {
                ind++;
                virtualHeader.length++;
                virtualHeader = virtualHeader.next;
            }
            // 修正指针和长度
            temp.next = virtualHeader.next;
            virtualHeader.next = temp;
            virtualHeader.length++;
            temp.length = temp.next.length + 1;
            // 修正当前节点
            correctTheCurrentNode(virtual);
        }
    }

    private void correctTheCurrentNode(MyLinkedList virtual) {
        if (virtual.next == null) {
            this.val = 0;
            this.next = null;
            this.length = 0;
        } else {
            this.val = virtual.next.val;
            this.next = virtual.next.next;
            this.length = virtual.next.length;
        }

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        MyLinkedList virtual = virtualNode();
        MyLinkedList virtualTwo = virtual;
        int ind = 0;
        // 到目标索引的前一位
        while (ind < index) {
            ind++;
            virtualTwo = virtualTwo.next;
            virtualTwo.length--;
        }
        virtualTwo.next = virtualTwo.next.next;
        correctTheCurrentNode(virtual);
    }

    private MyLinkedList virtualNode() {
        MyLinkedList virtual = new MyLinkedList(0, 0);
        MyLinkedList virtualHeader = new MyLinkedList(this.val, length);
        virtualHeader.next = next;
        virtual.next = virtualHeader;
        return virtual;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);

    }
}
