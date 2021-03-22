//  2021 3 22


package com.company.programmers;

public class Test12926 {
    public static void main(String[] args) {
        //System.out.println((int) 'z');
        System.out.println(solution("AaZz",	25));
//n:25 ->ZzYy
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                answer.append(' ');
            } else if (c[i]+n >= 'z') {
            } else {
                answer.append((char) (c[i] + n));
            }
        }

        return answer.toString();
    }
}
