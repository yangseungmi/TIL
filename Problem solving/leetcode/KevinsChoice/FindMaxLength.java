/*
525. Contiguous Array
https://leetcode.com/problems/contiguous-array/

여러가지로 시도했지만 내 수준은 아직 거기서 거기였다 ㅎㅎㅎㅎ 그래도 재밌다!
쉽지 않은 문제였고, Solution을 보니 문제보다 잠깐 스쳐간 로직이었고,
그때 용기내서 짜볼걸 그랬다. 먼가 머릿속에 점차 조금씩 잡혀가는것 같다. :)

map.containsKey(Object)

*/
package com.company.leetcode;

import java.util.HashMap;

public class FindMaxLength525 {
    public static void main(String[] args) {
        //int[] input = {0, 1};
        //int[] input = {0, 1, 0, 1}; // 4
        //int[] input = {0, 0, 0, 1, 1, 1, 0}; // 6
        int[] input = {0, 0, 1, 0, 0, 0, 1, 1}; // 6
        System.out.println(findMaxLength(input));
    }

    public static int findMaxLength(int[] nums) {
        int zero = 0;
        int one = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            }
            if (i + 1 == nums.length) return sum;
            if (nums[i] < nums[i + 1] && zero == one) {
                sum += Math.min(zero, one) * 2;
            }
            if (nums[i] > nums[i + 1]) {
                zero = 0;
                one = 0;
            }
        }
        return sum;
    }

    public static int findMaxLength1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(cnt)) {
                max = Math.max(max, i - map.get(i));
            } else {
                map.put(cnt, i);
            }
        }
        return max;
    }
}
