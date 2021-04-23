/*
Test12981 영어끝말잇기
https://programmers.co.kr/learn/courses/30/lessons/12981

튜닝해서 다시 채점해 보았다,
*/
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
         int[] answer = new int[2];

        char wordStart;
        char wordEnd = words[0].charAt(words[0].length()-1);

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        int i = 1;
        // n : 3
        // words : "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
        while (i < words.length) {
            set.add(words[i]);

            wordStart = words[i].charAt(0);

            if(wordEnd!=wordStart || set.size() != i+1) {
                // 진 사람
                answer[0] = (i % n) +1;
                // 진 사람이 몇번째인지
                answer[1] = (i / n) +1;
                break;
            } 
            wordEnd = words[i].charAt(words[i].length()-1);
            i++;
        }

        return answer;
    }
