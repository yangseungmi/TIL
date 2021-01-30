// 2021 . 1 . 29


//프로그래머스 Queue 문제 '더 맵게'(난이도 하)
// 문제 https://programmers.co.kr/learn/courses/30/lessons/42626

// Queue
// add(data);  offer()와 같은 기능으로 data 값을 queue에 추가하는 메소드.
// poll(); 제일 앞에 있는 값을 꺼내서 출력. 값이 없으면 null 출력.
// peek(); poll과 같이 제일 앞에 있는 값을 출력해주지만 꺼내지는 않음.
// remove(); queue의 첫번째 항목을 제거
// isEmpty(); queue 값이 비어있으면 true를 반환.

package com.company.programmers;

import java.util.PriorityQueue;

public class test42626 {
    public static void main(String[] args) {
        int[] scoville = {3,4,10,11};
        int K = 7;

        int answer = solution(scoville, K);
        System.out.println(answer);
    }

    private static int solution(int[] scoville, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int count = 0;
        while( queue.peek() < k){
            if(queue.size() < 2) {
                return -1;
            }
            int weakHot = queue.poll();
            int secondWeakHot = queue.poll();

            int mix = weakHot + secondWeakHot * 2;
            queue.add(mix);
            count ++;
        }
        return count;

    }
}
