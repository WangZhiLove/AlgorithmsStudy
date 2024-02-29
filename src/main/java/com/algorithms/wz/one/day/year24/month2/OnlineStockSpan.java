package com.algorithms.wz.one.day.year24.month2;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/online-stock-span/">901. 股票价格跨度</a>
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 */
public class OnlineStockSpan {
}

// 这道题目就是设计算法，然后每次给出价格，返回价格跨度，直接暴力破解吧
class StockSpanner {

    List<Integer> list = new ArrayList<>();

    public StockSpanner() {

    }


    public int next(int price) {
        list.add(price);
        int result = 0;
        // 题目理解错了，需要返回的是连续跨度
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= price) {
                result ++;
            } else {
                break;
            }
        }
        return result;
    }
}
