package com.algorithms.wz.data.structure.str;

import java.util.Scanner;

public class ReplaceNumClass {

    private String number = "number";

    public String replaceNUm(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - '0' >= 1 && arr[i] - '0' <= 9) {
                sb.append(number);
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        ReplaceNumClass replaceNumClass = new ReplaceNumClass();
        System.out.println(replaceNumClass.replaceNUm(str));
        in.close();
    }
}
