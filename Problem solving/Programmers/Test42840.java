// 2021 3 27

/*
https://programmers.co.kr/learn/courses/30/lessons/42840#
*/

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] m1 = {1, 2, 3, 4, 5};
        int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int s1 = 0, s2 = 0, s3 = 0;
        for (int i = 0; i < answers.length; i++) {
            s1 += m1[i % 5] != answers[i] ? 0 : 1;
            s2 += m2[i % 8] != answers[i] ? 0 : 1;
            s3 += m3[i % 10] != answers[i] ? 0 : 1;
        }

        List<Integer> list = new ArrayList<Integer>();
        int max = Math.max(s1, Math.max(s2, s3));
        if (max == s1) list.add(1);
        if (max == s2) list.add(2);
        if (max == s3) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
