// 2021 3 1

package com.company.codility;

import java.util.HashSet;

public class Test4 {
    public static void main(String[] args) {
        int[] A = {2,3,4,5};

        HashSet<Integer> set = new HashSet<>();
        for(int a : A){
            set.add(a);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!set.contains(i)){
                System.out.println(i);
            }
        }
        System.out.println(-1);
    }
}
