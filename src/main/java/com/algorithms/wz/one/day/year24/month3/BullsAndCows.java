package com.algorithms.wz.one.day.year24.month3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/bulls-and-cows/description/">299. 猜数字游戏</a>
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * <p>
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * <p>
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * <p>
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 */
public class BullsAndCows {

    /**
     * 这道题目相对来说比较容易思考
     * @param secret 秘密数字
     * @param guess 朋友猜测的数字
     * @return 对朋友这次猜测的提示
     */
    public String getHint(String secret, String guess) {
        // 仔细想了一个，我可以分两次遍历，第一次找到公牛的个数以及秘密数字中非公牛的所有数字，保存下来，
        // 第一次的时候也要保存公牛的位置，第二次的时候从第一次保留的数字中找到非公牛的个数
        // 声明一个数组，保存秘密数组中非公牛的字符
        List<Character> noBulls = new LinkedList<>();
        // 声明一个数组，保存公牛的位置
        List<Integer> bullIndList = new ArrayList<>();
        // 第一次遍历，找到公牛的数
        char[] charArray = secret.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == guess.charAt(i)) {
                bullIndList.add(i);
            } else {
                noBulls.add(charArray[i]);
            }
        }
        // 找到非公牛的数
        int cowNum = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (bullIndList.contains(i)) {
                continue;
            }
            char c = guess.charAt(i);
            if (noBulls.contains(c)) {
                cowNum ++;
                noBulls.remove((Character) c);
            }
        }
        return bullIndList.size() + "A" + cowNum + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        String hint = bullsAndCows.getHint("1807", "7810");
        System.out.println(hint);
    }

    /**
     * 优化，优化的思路是什么呢？怎么能经过一次遍历，得到两个结果呢？或者说经过一次遍历，得到公牛数，但是其它数字出现的次数都可以保留呢？
     * @param secret 秘密数字
     * @param guess 朋友猜测的数字
     * @return 对朋友这次猜测的提示
     */
    public String getHint1(String secret, String guess) {
        int bulls = 0;
        // secret 非公牛数各个字符出现的次数
        int[] cntS = new int[10];
        // guess 非公牛数各个字符出现的次数
        int[] cntG = new int[10];
        // 遍历得到公牛数和非公牛数字符次数
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        // 计算非公牛数
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
