/*
Lesson 4. FrogRiverOne
https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

HashSet을 사용해서 결과를 도출해내긴 했지만 100점이 안나와서 왜그럴까했는데
다른 사람이 짠 소스를 보니 경의로웠다...
나도 그래서 경의로운 소스를 카피하고, 응용하고, 만들어낼 수 있도록 매일매일 꾸준히 해 볼 생각이다.

목표는 일단 하루에 2~3개 정도?ㅎㅎ

HashSet 하면서 HashMap과 차이도 한번 정리.
공통점 : 값에 중복은 안된다.
차이점 : HashSet은 Value만, HashMap은 <Key, Value> 형식
(추가로 HashTable을 보면 null을 허용하지 않아요:))
*/

package com.company.codility;

import java.util.HashSet;

public class FrogRiverOne {
    public static void main(String[] args) {

        int x = 5;
        int[] arr = {1,3,1,4,2,3,5,4};
        //int[] arr = {1};
        System.out.println(solution1(x,arr));
    }

    public static int solution(int X, int[] A) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                set.remove(A[i]);
            }
            if (set.isEmpty()) {
                return i;
            }
        }
        return -1;

    }
    public static int solution1(int X, int[] A) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i] <= X) {
                set.add(A[i]);
                if (set.size() == X) {
                    return i;
                }
            }
        }
        return -1;

    }
}
