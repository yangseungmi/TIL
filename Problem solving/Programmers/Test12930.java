// 2021 3 29

/*
 https://programmers.co.kr/learn/courses/30/lessons/12930#qna
*/

class Solution {
    public String solution(String s) {
        // "AbC dEf"로 들어왔을 때
        // index로 카운트를 세준다
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // 공백이면 공백을 append해주고 index를 0으로 초기화
            if(s.charAt(i) == ' ') {
                sb.append(' ');
                index = 0;
            } else {
                if(index % 2 != 0) {
                    // 홀수는 소문자
                    sb.append(Character.toLowerCase(s.charAt(i)));
                    index ++;
                } else {
                    // 짝수는 대문자
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    index ++;
                }
            }
        }

        return sb.toString();
    }
}
