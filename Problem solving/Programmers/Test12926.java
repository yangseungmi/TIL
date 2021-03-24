//  2021 3 22

/*
Input AaZz
A +25 -> Z
z +25 -> a

Output ZzYy
*/

package com.company.programmers;

public class Test12926 {
    public static void main(String[] args) {
        System.out.println(solution("AaZz", 25));
    }

    public static String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char[] c = s.toCharArray();

        for (char value : c) {
            if (value == ' ') {
                answer.append(' ');
            } else if (value >= 'a' && value <= 'z') {
                if (value + n > 'z') {
                    answer.append((char) (value + n - 26));
                } else {
                    answer.append((char) (value + n));
                }
            } else if (value >= 'A' && value <= 'Z') {
                if (value + n > 'Z') {
                    answer.append((char) (value + n - 26));
                } else {
                    answer.append((char) (value + n));
                }
            }
        }

        return answer.toString();
    }
}
