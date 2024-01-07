package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">17.电话号码的字母组合</a>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinationsOfAPhoneNumber {

    private Map<String, String[]> phoneMap = new HashMap<>();

    {
        phoneMap.put("2", new String[]{"a", "b", "c"});
        phoneMap.put("3", new String[]{"d", "e", "f"});
        phoneMap.put("4", new String[]{"g", "h", "i"});
        phoneMap.put("5", new String[]{"j", "k", "l"});
        phoneMap.put("6", new String[]{"m", "n", "o"});
        phoneMap.put("7", new String[]{"p", "q", "r", "s"});
        phoneMap.put("8", new String[]{"t", "u", "v"});
        phoneMap.put("9", new String[]{"w", "x", "y", "z"});
    }

    private StringBuilder sb = new StringBuilder();

    private List<String> result = new ArrayList<>();

    /**
     * 回溯套模板，提前定义出各个数字对应的字母
     * @param digits 字符串
     * @return 所有的组合
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        String[] digitsArr = digits.split("");
        backtracking(digitsArr, 0);
        return result;
    }

    private void backtracking(String[] digitsArr, int index) {
        if (sb.length() == digitsArr.length) {
            result.add(sb.toString());
            return;
        }
        String[] numberOfStringArr = phoneMap.get(digitsArr[index]);
        for (String s : numberOfStringArr) {
            sb.append(s);
            backtracking(digitsArr, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
