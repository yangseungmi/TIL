/*
605. Can Place Flowers
https://leetcode.com/problems/can-place-flowers/

조건의 중요성을 알게 해준 문제였다 ㅎㅎ
Array
*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            
            if(flowerbed[i] == 0 // 꽃 심을 곳이 0인 경우
              && (i == 0 || flowerbed[i-1] == 0) // 앞이 0인 경우
              && (i == flowerbed.length-1 || flowerbed[i+1] == 0) // 다음칸이 0인 경우
              ){
                flowerbed[i] = 1; //심었으니까
                cnt ++;
            }
        }
        return cnt >= n;
    }
}
