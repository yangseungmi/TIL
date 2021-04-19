/*
Test42885. 구명보트
https://programmers.co.kr/learn/courses/30/lessons/42885

프로그래머스 Level 2 난이도가 나한테 아직 쉽진 않다. 그래도 포기하지 않고 계속 풀다보면
더 터득하지 않을까 싶다. 3문제 정도 더 풀다 자야겠다!

특별한 Object를 사용한 것도 아니고, 문제를 딱 봤을때 너무 쉽게 생각했다ㅜ

*/
package com.company.programmers;

import java.util.Arrays;

public class Test42885 {
    public static void main(String[] args) {
        int[] p = {30,30,30,70,20};
        int limit = 100;
        System.out.println(solution(p, limit));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int st = 0;
        for (int ed = people.length -1; ed >= st; ed --) {
            if (people[st] + people[ed] <= limit) {
                st++;
            }
            answer++;
        }
        return answer;
    }
}
