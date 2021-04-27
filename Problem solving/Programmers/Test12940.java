/*
Test12940 최대공약수와 최소공배수
https://programmers.co.kr/learn/courses/30/lessons/12940

100일 커밋 마지막날 ㅎㅎ
고생했다 :)
*/

package com.company.programmers;

public class Test12940 {
    public static void main(String[] args) {
        int[] ret = solution(4,6);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        int largeVal = Math.max(n, m);

        // 4, 6
        for (int i = largeVal; i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                // 유클리드 호제법 : 두 수를 곱한 뒤 최대공약수로 나누면 최소공배수
                answer[0] = i;
                answer[1] = n * m / i;
                break;
            }
        }

        return answer;
    }
}
