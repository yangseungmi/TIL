// 2021 3 2

package com.company.codility;

public class Test5 {
    public static void main(String[] args) {
        int[] A = {};


        if(A.length == 0){
            System.out.println(0);
        }

        if(A[0] > 4){
            System.out.println(0);
        }
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if(A[i]>4){
                System.out.println(0);
            }
            if(max < A[i]){
                max = A[i];
            }
            if(min > A[i]){
                min = A[i];
            }
        }
        int m = (max + min) / 2;

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += Math.abs(A[i] - m);
        }
        System.out.println(sum);

    }
}
