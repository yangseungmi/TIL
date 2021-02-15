// 2021 2 15
// 지호오빠 생일


/*
주식가격 문제
[1,2,3,2,3] -> [4,3,1,1,0]
*/

package com.company.programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test42584 {
    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,3,2,3};
        int[] b = solution(a);
        for (int t :b) {
            System.out.println(t);
        }


        IntStream st = Arrays.stream(b);
        st.forEach(t -> System.out.print(t+","));


    }
    public static int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j==size-1) answer[i] = j-i;
            }

        }
        return answer;
    }
}



