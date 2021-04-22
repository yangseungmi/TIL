/*
Test12981 영어끝말잇기
https://programmers.co.kr/learn/courses/30/lessons/12981


*/

package com.company.programmers;

import java.util.HashSet;

public class Test12981 {
    public static void main(String[] args) {
        String[] s = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] ret = solution(3, s);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        int i = 0;
        // n : 3
        // words : "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
        while (i < words.length) {
            if (set.contains(words[i])
                    || words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                // 진 사람
                answer[0] = i % n != 0 ? i % 3 : 3;
                // 진 사람이 몇번째인지
                answer[1] = i / n;
                break;
            } else {
                set.add(words[i]);
            }
            i++;
        }

        return answer;
    }
}
