// 2022 2 8
/*
https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

numbers	        target	return
[1, 1, 1, 1, 1]	3	      5
[4, 1, 2, 1]	  4       2

*/
class Solution {
    static int answer;
    public void dfs(int[] numbers, int target, int idx, int sum){

        if (idx == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        int add = sum + numbers[idx];
        int sub = sum - numbers[idx];
        dfs(numbers, target, idx+1, add);
        dfs(numbers, target, idx+1, sub);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0,0);
        
        return answer;
    }
}
