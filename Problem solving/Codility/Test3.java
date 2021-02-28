 // 2021 2 28

/*
코딜리티 홀수 갯수인 숫자 찾기

*/

package com.company.codility;

import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) {
        int[] A = new int[]{9, 3, 9, 3, 7, 7, 3, 3, 1};
        int ret = solution(A);
        System.out.println(ret);
    }

    private static int solution(int[] a) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int j : a) {
            hm.put(j, hm.getOrDefault(j, 0) + 1);
        }
        for (int t : hm.keySet()) {
            if (hm.get(t) % 2 == 1) {
                return t;
            }
        }
        return 0;
    }
}
