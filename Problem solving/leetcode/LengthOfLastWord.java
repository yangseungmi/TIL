/*
58. Length of Last Word
https://leetcode.com/problems/length-of-last-word/

easy 문제도 풀어보았다...
알고리즘 실력을 늘리기엔 진짜 많은 시간과 노력이 필요한걸 또 새삼 느낀다.
나는 집중력이 없어 80%까지 와도 머리가 지끈거리면 복잡해서 정답을 보거나 딴짓을 하고 있었다...
쫌만 더 가면 20%를 채워 정답에 도달할 수 있었는데ㅠ
끝까지 집중하는 노오력이 많이 필요하다!...
포기하지 말자~



*/
class Solution {
    public int lengthOfLastWord(String s) {
        int end = 0;
        int cnt = 0;
        boolean start = false;
        for(int i =s.length()-1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                start = true;
                cnt++;
            }
            if(start && s.charAt(i) == ' '){
                return cnt;
            }
        }
        return cnt;
    }
}
