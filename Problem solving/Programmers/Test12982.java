/*
Test12982 예산
https://programmers.co.kr/learn/courses/30/lessons/12982

오늘은 행복한 피곤함에 Level 1 문제로 커밋을 하고 싶었다 :)
이제 Level 1은 호딱 해치우니 더 일찍 의자에 앉아 Level 2 문제 푸는 습관을 가져야 할 거 

*/
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int sum = 0;
        int i = 0;
        Arrays.sort(d);
        for(i = 0; i< d.length; i++) {
            sum+=d[i];
            if(sum>budget)
                return i;
            else if(sum == budget)
                return i+1;
        }
        return i; 
    }
}
