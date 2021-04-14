/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

문제 이해를 못해 뺑 돌아 해결한 문제이다ㅜ
가장 낮은 가격에 사서 가장 높은 가격에 파는 거였는데..

그래도 다음에 비슷한 문제가 나오면 풀 수 있을 거 같다.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profitMax = 0;
        // 가장 낮은 가격에 사서 가장 높은 가격에 판다.
        for (int i = 0; i < prices.length; i++) {

            if(prices[i] < min){
                min = prices[i];
            }
            if(profitMax < prices[i] - min){
                profitMax = prices[i] - min;
            }
        }
        return profitMax;
    }
}
