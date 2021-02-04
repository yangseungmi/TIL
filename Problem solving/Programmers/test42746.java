// 2021 2 4

// 가장 큰 수
//[6, 10, 2]	6210
// 난이도 중

package com.company.programmers;

import java.util.Arrays;

public class test42746 {

    public static void main(String[] args) {
        int n [] = new int[]{6,10,2};
        String ans = solution(n);
        System.out.println(ans);
    }
    public static String solution(int[] numbers) {
        String answer = "";

        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(s, (o1, o2)->{
            if(o1.charAt(0) == o2.charAt(0)){
                int a = Integer.parseInt(o1 + o2);
                int b = Integer.parseInt(o2 + o1);
                return b - a;
            }
            return o2.charAt(0) - o1.charAt(0);
        });

        StringBuilder sb = new StringBuilder();
        for (String t : s) {
            sb.append(t);
        }
        answer = sb.charAt(0) == '0' ? "0" : sb.toString();
        return answer;
    }
}

//여기서 나는 Arrays.sort를 사용했지만 다른 분들의 문제 풀이를 보니 Collection을 사용하셨다.

public static String solution(int[] numbers) {
// 리스트에 담는다
  List<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i<numbers.length; i++){
        list.add(numbers[i]);
    }
    
     Collections.sort(list, (o1, o2)->{
        String a = String.valueOf(o1);
        String b = String.valueOf(o2);

        int ab = Integer.parseInt(a+b);
        int ba = Integer.parseInt(b+a);
        return -Integer.compare(ab, ba);
    });
        
    StringBuilder sb = new StringBuilder();
    for(Integer t : list) {
        sb.append(t);
    }
    
    answer = sb.charAt(0) == '0' ? "0" : sb.toString();
    return answer;
}
