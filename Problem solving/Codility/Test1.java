// 2021 2 20

/*
첫 코디널리티 문제를 풀어보았다.
앞으로 변수명 네이밍에 신경을 더 써야할것같다.
*/

package com.company.codility;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(529));
    }
    public static int solution(int N) {
        int result = 0; //가장 큰수
        String input = Integer.toBinaryString(N);
        char[] arrCh = input.toCharArray();

        int n = 0;
        for (char value : arrCh) {
            if (value == '0') {
                n++;
            } else {
                if (result < n) {
                    result = n;
                }
                n = 0;
            }
        }

        System.out.println(input);

        return result;
        // write your code in Java SE 8
    }
}
