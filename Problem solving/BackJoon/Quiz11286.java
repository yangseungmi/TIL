// 2021 2 17

/*
절댓값 힙 문제
*/
package com.company.armicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Quiz11286 {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        for(int i = 0 ; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }else{
                queue.add(val);
            }
        }
    }
}
