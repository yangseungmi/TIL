/*
  674. Longest Continuous Increasing Subsequence
  https://leetcode.com/problems/longest-continuous-increasing-subsequence/
  
  이 문제는 처음에 아예 이해를 제대로못해서ㅠ 방향을 잘못잡아서 못풀었던 문제이다.
  앞으로는 문제를 잘 이해하는 스킬을 쌓도록 노력할 것이다.
  Math.max
*/
package com.company.leetcode;

public class Longest674 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2}));
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        System.out.println(findLengthOfLCIS(new int[]{1, 4, 5}));
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{1, 2}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int tmpAns = 0;
        int ans = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i + 1]) {
                ans++;
            } else {
                tmpAns = Math.max(tmpAns, ans);
                ans = 0;
            }
        }
        return Math.max(tmpAns, ans) + 1;
    }
}
