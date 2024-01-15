package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/lemonade-change/description/">860.柠檬水找零</a>
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class LemonadeChange {

    /**
     * 这个题目因为只有 5，10，20，那我提前声明一个长度为 3 的数组，索引 0 是 5 的个数，索引 1 是 10 的个数，索引 2 是 20 的个数，遇到 10，索引 0 的值-1，
     * 遇到 20，索引 1 减 1 并且索引 0 减 1 或者索引 0 减 3，只要存在负数，则返回 false
     * 其实想想最后不是要多少钱，而是正确找零，那我直接声明两个变量不就好
     * @param bills 柠檬水
     * @return 能否正确找零
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveNum ++;
            } else if (bill == 10) {
                tenNum ++;
                fiveNum --;
            } else {
                if (tenNum > 0) {
                    tenNum --;
                    fiveNum --;
                } else {
                    fiveNum -= 3;
                }
            }
            if (fiveNum < 0 || tenNum < 0) {
                return false;
            }
        }

        return true;
    }

}
