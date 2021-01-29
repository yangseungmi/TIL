// 2021 . 1 . 29


//프로그래머스 Queue 문제 '더 맵게'(난이도 하)
// 문제 https://programmers.co.kr/learn/courses/30/lessons/42626

// Queue
// add();
// poll();
// peek();

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
