// 2021 6 13
/*
Test42587 프린터
https://programmers.co.kr/learn/courses/30/lessons/42587?language=java


100일 커밋도 끝나고, 취업도 해서 문제 풀 시간을 내기 벅찼다...
블로그도 쓰고, 일기도 쓰고, 연애도 하고, 운동도, 거기다 제테크까지 ㅎㅎㅎ
그래도 머리속엔 이직 생각도 하고 있다... 이 중 코테가 제일 하기 귀찮아 미루고 있었던건 사실이다 :)

취업 전에 하루에 3개씩은 풀었는데 뚝 끊기니까 다시 풀려니 머리가 안돌아간다;;
다시 100일 커밋을 시작하던가 회사에서 스터디 추진이 시급해보인다

이 프린터 문제는 프로그래머스 스택&큐 문제인데 내가 이부분 취약해서 항상 멀리했던 유형이다...
오랜만에 도전해보면서 풀었는데 역시 쉽지 않았고, 문제 이해도 괜히 느려진거 같아 씁쓸하다

그래도 결국 이해를 했고, 클론이었지만 다음에는 혼자 해볼수.... 있을거같다

PriorityQueue in Queue
우선순위 큐
-  PriorityQueue<>(Comparator.reverseOrder())
  역순정렬 큐

*/

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // 역 큐 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : priorities){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == queue.peek()) {
                    if(location == i) {
                        return answer;
                    }
                    answer ++;
                    queue.poll();
                }
            }
        }
        return answer;
    }
}
