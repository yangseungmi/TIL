// 2021 1 19

// 섬의 개수(난이도 중)
package com.company.armicpc;

import java.io.*;
import java.util.StringTokenizer;

public class Quiz4963 {
    private static int w, h;
    private static int[][] map;
    private static boolean[][] isCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 0 0 일떄 빠져나옴
            if (w == 0 && h == 0) break;

            map = new int[h + 2][w + 2]; // 계산시 주위 인덱스 검사할때 오류생길수 있으니
            isCheck = new boolean[h + 2][w + 2];

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    isCheck[i][j] = false;
                }
            }

            int num = 0;
            // 섬을 세보자.
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j] == 1 && !isCheck[i][j]) {
                        getIsland(i, j);
                        num++;
                    }
                }
            }
            sb.append(num).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }

    static void getIsland(int h, int w) {

        map[h][w] = 0;
        // 대상을 둘러싸는 인덱스
        // ex) 대상 [1,1] : 주위 [0,0] [0,1] [0,2] / [1,0] [1,2] / [2,0] [2,1] [2,2]
        int[] search_h = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] search_w = {-1, -1, 0, 1, 1, 1, 0, -1};
        
        for (int i = 0; i < search_h.length; i++) {
            int around_y = h + search_h[i];
            int around_x = w + search_w[i];

            if (map[around_y][around_x] == 1) {
                isCheck[around_y][around_x] = true;
                getIsland(around_y, around_x);
            }
        }
    }
}


