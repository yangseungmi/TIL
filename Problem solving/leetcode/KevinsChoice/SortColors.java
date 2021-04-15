/*
75. Sort Colors
https://leetcode.com/problems/sort-colors/

보는 순간 HashMap 에 넣어 map을 0,1,2 돌리고 했지만
문제에서 의도한 방향과는 매우 달라 지우고 또 클론코딩을 했다 ;;
그래도 다음에 비슷한 문제가 나오면 풀수 있을 것 같다!!

Array, Swap
참고 : http://buttercola.blogspot.com/2014/09/leetcode-sort-colors.html

*/

package com.company.leetcode;

public class sortColors75 {
    public static void main(String[] args) {
        //int[] ret = sortColors(new int[]{2, 0, 2, 1, 1, 0});
        int[] ret = sortColors(new int[]{2,0,1});
        for (int t : ret) {
            System.out.print(t + ",");
        }
    }

    public static int[] sortColors(int[] nums) {

        // 받은 배열에서 처리한 뒤 출력.
        int st = 0;
        int ed = nums.length - 1;

        int i = 0;
        while (i <= ed) {
            if (nums[i] == 0) {
                swap(nums, i, st);
                st++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, ed);
                ed--;
            } else {
                i++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int st) {
        int temp = nums[i];
        nums[i] = nums[st];
        nums[st] = temp;
    }
}
