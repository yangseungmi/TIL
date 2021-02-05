// 20212 5

// 체육복 문제
// 난이도 하

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashSet<Integer> lostList = new HashSet<>();
        HashSet<Integer> resList = new HashSet<>();
        
        for(int i : reserve){
            resList.add(i);
        }
        for(int i : lost){
            if(resList.contains(i)){
                resList.remove(i);
            }
            else{
                lostList.add(i);
            }
        }
        for(int i : lost){
            if(lostList.contains(i)){
                if(resList.contains(i-1)){
                    resList.remove(i-1);
                }
                else if(resList.contains(i+1)){
                    resList.remove(i+1);
                }
                else{
                answer --;
                    
                }
            }
        }
        return answer;
    }
}
