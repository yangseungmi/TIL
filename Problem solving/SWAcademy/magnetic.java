// 2022 2 8

/*
톱니바퀴 머시기 문제인데 설명과 그림은 길지만 간단한 알고리즘.
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH

Input
2
2
0 0 1 0 0 1 0 0
1 0 0 1 1 1 0 1
0 0 1 0 1 1 0 0
0 0 1 0 1 1 0 1
1 1
3 -1
2
1 0 0 1 0 0 0 0
0 1 1 1 1 1 1 1
0 1 0 1 0 0 1 0
0 1 0 0 1 1 0 1
3 1
1 1

-> 
2개의 케이스가 있어.
1번 케이스에서는 2번 돌릴건데
4개의 톱니는 아래와 같이 생겼어(01010...)
1, 1 : 4개 중 2번째 톱니를 오른쪽(1) 시계방향으로 돌릴거야
3,-1 : 4개 중 4번째 톱니를 왼쪽(-1) 반시계방향으로 돌릴거야

Output
#1 10
#2 14
*/

package com.company.swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH

 */
public class magnetic {
    public static void main(String args[]) throws Exception {
        // 입력받아서 톱니 리스트 생성까지.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int[][] info = new int[4][8];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    info[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // K번 실행
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());

                int[] rotation = new int[4]; //회전할 방향을 저장
                rotation[num] = dir;

                // 오른쪽 자석들을 검사 num=1,dir=1
                for (int j = num+1; j <4; j++) {
                    // 검사하는 순서가 왼쪽 3번째 칸의 자성과 오른쪽 7번째 칸의 자성이다.

                    if(info[j-1][2] == info[j][6])
                        break;// 자성이 같으면 회전하지 않는다.
                    else
                        rotation[j] = -rotation[j-1];// 자성이 다르면 회전한다.
                }

                // 왼쪽 자석들을 검사
                for (int j = num-1; j >=0; j--) {
                    if(info[j][2] == info[j+1][6]) // 자성이 같으면 회전하지 않는다.
                        break;
                    else
                        rotation[j] = -rotation[j+1];
                }

                // 각 자석을 회전시킨다.
                for (int j = 0; j < 4; j++) {
                    if (rotation[j] == 0) //회전하지 않는 경우
                        continue;
                    else if (rotation[j] == 1) { // 시계방향 회전
                        int tmp = info[j][7];
                        for (int k = 7; k > 0; k--) {
                            info[j][k] = info[j][k - 1];
                        }
                        info[j][0] = tmp;
                    } else if (rotation[j] == -1) { // 반시계방향 회전
                        int tmp = info[j][0];
                        for (int k = 0; k < 7; k++) {
                            info[j][k] = info[j][k + 1];
                        }
                        info[j][7] = tmp;
                    }
                }

            }
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if(info[i][0]==1){
                    sum+=1<<i;
                }
            }
            System.out.print("");
            System.out.println("#"+tc+" "+sum);
        }
    }
}
