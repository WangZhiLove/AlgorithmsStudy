package com.algorithms.wz.skills.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/queue-reconstruction-by-height/description/">406.根据身高重建队列</a>
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class QueueReconstructionByHeight {

    /**
     * 这道题目想了半天，我可以以层的思想来找，先找到前面没有比我大的，形成链表，然后再找前面只有一个比我大的，依次类推，形成链表，最后遍历连表得到结果
     * 什么时候结束呢？声明一个变量记录吧
     *
     * 想歪了，先排序，后封装结果
     *
     * @param people 人的队列
     * @return 新的队列
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            // 这个很关键
            return o2[1] - o1[1];
        });
        int[][] ans = new int[people.length][];
        for (int[] person : people) {
            int num = person[1] + 1;
            for (int j = 0; j < ans.length; j++) {
                if (ans[j] == null) {
                    num --;
                    if (num == 0) {
                        ans[j] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        System.out.println(
            queueReconstructionByHeight.reconstructQueue(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }

    /**
     * 有个题解更有意思，相当于反转之前的思路，然后遍历使用链表
     * @param people 人身高
     * @return 数组
     */
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }

}
