// 2021.1.21

// 완주하지 못한 선수
// 처음으로 프로그래머스 페이지에서 문제를 풀어보았는데 여기서 다른 개발자분들의
// 소스를 보고... 하루종일 반성하는 시간을 가졌다
// HashMap과 많이 친해짐.

package com.company.programmers;

import java.util.HashMap;

public class SkillChecks3 {
    public static void main(String[] args) {

        String[] participant = new String[]{"leo", "kiki", "eden"};

        String[] completion = new String[]{ "eden","kiki"};

        String answer = "";
        /*
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i<participant.length-1;i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
            answer = participant[i+1];
        }
        System.out.println(answer);
        */

        HashMap<String, Integer> hm = new HashMap<>();

        for(String p : participant){
            hm.put(p,hm.getOrDefault(p,0) + 1);
        }
        for (String c : completion){
            hm.put(c, hm.get(c)-1);
        }
        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
            }
        }
        for(int a : hm.values()){
            System.out.println(a);
        }
        System.out.println(answer);
    }
}
