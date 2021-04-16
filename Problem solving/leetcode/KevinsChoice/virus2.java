/*
virus2

나도 드디어 Queue를 쓸 줄 알게 되었다.
대학생 때는 머리가 잘 돌아갔었는지 호다닥 만들었는데 이젠 시간이 좀더 필요하다ㅠ
연습을 더 많이 해야 할것 같다!
오늘 목표는 leetcode DFS mideum 문제까지...인데 할 수 있겠지?ㅎㅎ
화이팅 :)

Queue
*/

package com.company.armicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz2606_Queue {

    static int node[][];
    static int check[];
    static int n;
    static int cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 7
        int m = sc.nextInt();  // 6

        node = new int[n + 1][n + 1];
        check = new int[n + 1]; //0~6

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            node[x][y] = node[y][x] = 1;
        }
        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int i) {
        Queue<Integer> queue = new LinkedList<>();

        check[i] = 1;
        queue.offer(i);

        while (!queue.isEmpty()) {

            int poll = queue.poll(); // 하나씩 꺼내가면서 제일 최신 꺼

            for (int j = 1; j <= n; j++) {
                if (node[poll][j] == 1 && check[j] == 0) {
                    queue.offer(j);
                    check[j] = 1;
                    cnt++;
                }
            }
        }
    }
}

