// 2021 2 22

/*
https://www.acmicpc.net/problem/2156
백준 포도주 시식 문제 재귀로 풀었다.
*/

package com.company.armicpc;

import java.util.Scanner;

public class Quiz2156 {
    static int n; //N 입력
    static int dp[], cost[]; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n + 1]; // 먹은거 합산값
        cost = new int[n + 1]; // 포도주 배열


        for (int i = 1; i <= n; i++) { // 비용 입력
            cost[i] = sc.nextInt();// 배열에 값 넣어주고
        }

        dp[1] = cost[1];
        // n이 1인 경우 예외 처리.
        if(n>=2)
            dp[2] = cost[1] + cost[2];
        
        for(int i=3;i<=n;i++) {
            // 경우의 수 중 최댓값을 취한다.
            dp[i] = Math.max(
                Math.max(
                // i가 3인 경우
                    // cost[2] + dp[0] + cost[3]
                    cost[i-1]+dp[i-3]+ cost[i],
                    // dp[1] + cost[3]
                    dp[i-2]+ cost[i]
                )
                // dp[2]
                ,dp[i-1]) ;
        }

        System.out.println(dp[n]);

        sc.close();

    }

}
