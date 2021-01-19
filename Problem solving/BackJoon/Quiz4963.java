// 2021 1 19

// 섬의 개수(난이도 중)

package com.company.armicpc;

import java.io.*;
import java.util.StringTokenizer;

public class Quiz4963 {
    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        while (true){
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println("a"+map[0][0]);
    }
}
