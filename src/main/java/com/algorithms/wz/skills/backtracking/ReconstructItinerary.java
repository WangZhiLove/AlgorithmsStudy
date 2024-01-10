package com.algorithms.wz.skills.backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/reconstruct-itinerary/description/">332.重新安排行程</a>
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * <p>
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * <p>
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 */
public class ReconstructItinerary {

    private List<List<String>> list = new ArrayList<>();

    private List<String> temp = new ArrayList<>();

    boolean[] visit;

    /**
     * hard 题目，看起来就难，我的思路是寻找所有可能的情况，然后对比哪一个行程最小
     * 这个算法超出时间限制了，但是我觉得思路是对的
     * @param tickets 所有的飞机票
     * @return 最小的行程组合
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets.size() == 1) {
            return tickets.get(0);
        }
        visit = new boolean[tickets.size()];
        temp.add("JFK");
        backtracking(tickets, "JFK");
        if (list.size() == 1) {
            return list.get(0);
        }
        Collections.sort(list, (o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i).compareTo(o2.get(i));
                }
            }
            return 0;
        });
        return list.get(0);
    }

    private void backtracking(List<List<String>> tickets, String airport) {
        if (temp.size() == tickets.size() + 1) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(airport) && !visit[i]) {
                temp.add(tickets.get(i).get(1));
                visit[i] = true;
                backtracking(tickets, tickets.get(i).get(1));
                visit[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> itinerary = reconstructItinerary.findItinerary(tickets);
        itinerary.forEach(System.out::println);
    }


    Map<String, PriorityQueue<String>> map = new HashMap<>();

    List<String> itinerary = new LinkedList<>();
    public List<String> findItinerary2(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        itinerary.add("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String airport) {
        while (map.containsKey(airport) && map.get(airport).size() > 0) {
            String poll = map.get(airport).poll();
            dfs(poll);
        }
        itinerary.add(airport);
    }
}
