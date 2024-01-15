package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/gas-station/description/">134. 加油站</a>
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class GasStation {

    /**
     * 这道题目让我想起了回溯，遍历一遍，如果能回到起点，就返回起始点，解法没问题，就是超时了，这个给的案例有点离谱
     *
     * @param gas  加油站
     * @param cost 耗油量
     * @return -1 或者是起始索引
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int index = canComplete(gas, cost, i, gas[i] - cost[i]);
            if (index != -1) {
                return index;
            }
        }
        return -1;
    }

    private int canComplete(int[] gas, int[] cost, int startIndex, int totalGas) {
        if (totalGas < 0) {
            return -1;
        }
        int temp = startIndex + 1 >= gas.length ? 0 : startIndex + 1;
        while (temp != startIndex) {
            totalGas = totalGas + gas[temp] - cost[temp];
            if (totalGas < 0) {
                return -1;
            }
            temp++;
            if (temp == gas.length) {
                temp = 0;
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
//        System.out.println(gasStation.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
        System.out.println(gasStation.canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
    }

    /**
     * 题解的思路与我的相同，唯一一个优化点就是走过的路不会再走，这个是点睛之笔呀
     * @param gas  加油站
     * @param cost 耗油量
     * @return -1 或者是起始索引
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int result = 0;
        while (result < n) {
            int cnt = 0;
            int totalGas = 0;
            int totalCost = 0;
            while (cnt < n) {
                int j = (result + cnt) % n;
                totalCost += cost[j];
                totalGas += cost[j];
                if (totalGas < totalCost) {
                    break;
                }
                cnt ++;
            }
            if (cnt == n) {
                return result;
            } else {
                // 点睛之笔
                result = result + cnt + 1;
            }
        }
        return -1;
    }

}
