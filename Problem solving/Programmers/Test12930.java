// 2021 3 29

/*
 https://programmers.co.kr/learn/courses/30/lessons/12930#qna
*/

class Solution {
    public String solution(String s) {
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append(' ');
                index = 0;
            } else {
                if(index % 2 != 0) {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                    index ++;
                } else {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    index ++;
                }
            }
        }

        return sb.toString();
    }
}
