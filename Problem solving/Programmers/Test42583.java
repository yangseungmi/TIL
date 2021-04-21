/*
Test42583 다리를 지나는 트럭
https://programmers.co.kr/learn/courses/30/lessons/42583

Queue와 더 친해질 수 있는 문제였다. 처음에 문제를 이해하기도 약간 시간이 걸리긴 했지만
풀어보니 재밌었고, 다음에 비슷한 문제를 만났을때 더 술술 풀고 싶다!

Queue LinkedList,

*/
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
          int sec = 0;
        Queue<Integer> bridge = new LinkedList<>();

        int max = 0;
        for (int i = 0; i < truck_weights.length; i++) {

            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck_weights[i]);
                    max += truck_weights[i];
                    sec++;
                    break;
                } else if (bridge.size() == bridge_length) {//2개면
                    max -= bridge.poll();
                } else {
                    if (max + truck_weights[i] <= weight) {
                        bridge.offer(truck_weights[i]);
                        max += truck_weights[i];
                        sec++;
                        break;
                    } else { 
                        bridge.offer(0);
                        sec++;
                    }
                }
            }
        }
        return sec + bridge_length;
    }
}
