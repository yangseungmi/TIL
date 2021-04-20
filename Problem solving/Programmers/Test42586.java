/*
Test42586 기능개발
https://programmers.co.kr/learn/courses/30/lessons/42586#qna

예전에 이 문제를 보고 나는 안되겠다 싶어 넘긴게 기억난다.
지금도 보자마자 술술 풀어내지는 못했지만 이제는 Lv 2와 친해져야 해서 그냥 지나칠순 없었고,
아직 내가 Stack, Queue에 약하기 때문에 오늘은 이 문제를 잡고 가야할 거 같아 커밋한다.

Queue LinkedList ,
queue.isEmpty
queue.offer (또는 add)
queue.poll() 꺼내오기, peek() 알려주기


double과 int 계산,
ex) Math.ceil(70/30) = 2.0
Math.ceil(70/(float)30) = 3.0


List -> []   ret.stream().mapToInt(i->i).toArray()

Optional null 체크
Optional.ofNullable(queue.poll()).orElse(0)

*/
package com.company.programmers;

import java.util.*;

public class Test42586 {
    public static void main(String[] args) {
        int[] answer = solution(new int[]{93, 30, 55},
                new int[]{1, 30, 5});

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ret = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.add(day);
        }

        int cnt = 1;
        int prev = Optional.ofNullable(queue.poll()).orElse(0);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(prev >= now){
                cnt ++;
            }
            else {
                ret.add(cnt);
                cnt = 1;
                prev = now;
            }
        }
        ret.add(cnt);

        return ret.stream().mapToInt(i->i).toArray();
    }
}
