// 2021.1.24

// K번째 수
// 내 코드와 다른 사람의 코드를 비교 해보고 또 현타가 왔다.
// Arrays.copyOfRange() 라는걸 사용하고 있었다. 필요없는 배열변수를 또 선언할 필요가 없었다.
// Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 기준

package com.company.programmers;

import java.util.Arrays;

public class SkillChecks2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,6,3,7,5,6,2,7,8,9};
        int[][] commands = {
                {2,5,2},{4,7,2}
        };
        int[] a = solution(arr,commands);
        for (int i = 0; i < commands.length; i++) {
            System.out.println(a[i]);
        }
    }
/*
    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        int num = commands.length;
        for (int i = 0; i < num; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int n = commands[i][2]-1;

            int[] ar = new int[end-start + 1];
            for (int j = start, k=0; j <= end; j++,k++) {
                ar[k] = array[j];
            }
            Arrays.sort(ar);
            answer[i]= ar[n];
        }


        return answer;
    }
*/

    private static int[] solution(int[] array, int[][] commands) {
    
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
