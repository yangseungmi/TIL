/*
BackJoon Leetcode
2606. virus
https://www.acmicpc.net/problem/2606

DFS를 뽀개기 위해 간단한 문제부터 풀어보았다. 백준 알고리즘은 Input 부터 맞춰줘야해서 
귀찮긴 하지만 이 문제를 통해 DFS와 가까워졌다 ㅎㅎ(사실 아직 Queue 시작도 안함)


재귀함수, Scanner
*/

package com.company.armicpc;

import java.util.Scanner;

public class Quiz2606 {

    static int map[][];
    static int visit[];
    static int n, m, v;
    static int count = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt(); // 7
        m = scan.nextInt(); // 6

        map = new int[n+1][n+1];
        visit = new int[n+1];

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(1);
        System.out.println(count);

    }

    private static void dfs(int i) {
        visit[i] = 1;
        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 1 && visit[j] == 0) {
                dfs(j);
                count++;
            }
        }
    }

}

