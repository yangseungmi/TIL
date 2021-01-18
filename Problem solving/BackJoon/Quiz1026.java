// 2021.1.18

// 보물(난이도 하)
// S = A[0]×B[0] + ... + A[N-1]×B[N-1]
// 최소값 구하기
package com.company.armicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] a = new int[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[num];
        for (int i = 0; i < num; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a); //오름차순 정렬
        Arrays.sort(b); //오름차순 정렬
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += a[i] * b[num - i - 1]; // 각 배열의 끝에서부터 곱한 값을 더해준다
        }
        
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
