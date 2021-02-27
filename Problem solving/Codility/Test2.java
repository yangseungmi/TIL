// 2021 02 27

/*
코딜리티 2번째 문제.

CyclicRotation 주어진 단계 수만큼 배열을 오른쪽으로 회전하는 문제였다.
*/
package com.company.codility;

public class Test2 {
    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};

        int K = 14;

        int l = A.length;//5
        int k = K % l; //4

        int[] A1 = new int[l];
        for (int i = 0; i < l; i++) {
            if (i<k)
                A1[i]=A[i+l-k] ;
            else
                A1[i]=A[i-k];
        }

        for (int t : A1) {
            System.out.println(t);
        }
        System.out.println("--");
    }
}
