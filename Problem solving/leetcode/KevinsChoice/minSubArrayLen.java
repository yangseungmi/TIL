/*
209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/

이 문제를 처음 본 순간 쉬어보였고, Map에 넣고 sort 하면 되는 줄 알았지만 나의 큰 오산이었다...
이것도 마찬가지로 문제를 이해 못해 뺑 돌았고, 결국 답을 찾지 못해 답을 보았고,
그럼에도 이해가 되지않았다!... 역시 내껄로 만드는건 쉽지 않았고, 어제 저녁부터
오늘 점심까지 계속 머리굴리다 드디어 해결했다!!! 
이제 mideum도 잘 할 수 있을거 같다~~

Array
*/

package com.company.leetcode;

public class MinSubArrayLen209 {
    public static void main(String[] args) {
        System.out.println("ans:" + minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3, 1, 1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            end = i;
            currentSum += nums[i];

            System.out.println(nums[start]);
            while ((currentSum - nums[start]) >= target) {
                int n = nums[start++];
                currentSum -= nums[start++];
            }

            if (currentSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
            }
        }
        return currentSum >= target ? minLength : 0;
    }


    public static int minSubArrayLen1(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {

                sum += nums[j];
                if (sum >= target) {
                    length = Math.min(length, j-i+1);
                    break;
                }

            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;

    }


}
