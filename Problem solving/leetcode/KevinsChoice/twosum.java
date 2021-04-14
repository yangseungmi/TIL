
/*
1. Two Sum
https://leetcode.com/problems/two-sum/
 이 문제는 배열에서 두 수를 더해 target 값을 찾는 좌표를 구하는 문제이다.
 쉬어보였지만 쉽지 않고 아래 3가지 케이스로 구현해보았다.
 HashMap, Array
*/

package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Twosum {
    public static void main(String[] args) {
        int[] arr = twoSum3(new int[]{-2,7,11,15,3}, 10);
        System.out.println(Arrays.toString(Arrays.stream(arr).toArray()));
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] answer = new int[2];
        int i = 0;
        while (i < nums.length + 1) {
            int sum = target;
            sum -= nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sum == nums[j]) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
            i++;
        }
        return answer;
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (hm.containsKey(s) && hm.get(s) != i) {
                return new int[]{i, hm.get(s)};
            }
        }
        return new int[]{0, 0};
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if(hs.containsKey(s)){
                return new int[]{hs.get(s),i};
            }
            else {
                hs.put(nums[i],i);
            }
        }
        return new int[]{0, 0};
    }
}
