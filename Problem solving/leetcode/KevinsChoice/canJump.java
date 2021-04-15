/*
55. Jump Game
https://leetcode.com/problems/jump-game/

이 문제로 알고리즘이 더 재밌어졌다 :)
역시 처음 봤을땐 간단해 보였다ㅠ
너무 만만히 봤고 내가 오만했던것이다..
쉬어 보이는 문제였는데 알고 보니 조금 복잡한 문제였고,
이해를 하니 너무 재밌었다 ㅎㅎㅎ

Array, Math.max, throw Exception
ex) throw new IllegalArgumentException();

*/
package com.company.leetcode;

public class canJump55 {
    public static void main(String[] args) {
        //System.out.println(canJump(new int[]{2,0}));
        //System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{2,5,0,0,0,0,0,0,0}));
    }

    public static boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        throw new IllegalArgumentException("input is not valid");
    }
}
