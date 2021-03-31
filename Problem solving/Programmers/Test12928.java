// 2021 3 31

/*
https://programmers.co.kr/learn/courses/30/lessons/12928#
*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n == 1) return 1;
        for(int i = 1; i <= n/2;i++){
            if(n % i == 0) {
                answer += i;
               /*
                if(i != n / i) {
                    answer += n / i;
                }
                if(i * i == n) {
                    return answer;
                }
                if((i + 1) == n / i) {
                    return answer;
                }
                */
            }
        }
    
        return answer+n;
    }
}
