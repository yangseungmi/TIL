/*
567. Permutation in String
https://leetcode.com/problems/permutation-in-string/

이 Medium 문제를 내가 혼자 풀다니!!!
내가 발전하는게 눈에 보이는것 같아 완전 뿌듯하다 :)

private static String sort(String s) {
    char[] t = s.toCharArray();
    Arrays.sort(t);
    return new String(t);
}
*/
package com.company.leetcode;

import java.util.Arrays;

public class CheckInclusion567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("cab", "eidbacooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
                return true;
            }
        }
        return false;
    }

    private static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}

