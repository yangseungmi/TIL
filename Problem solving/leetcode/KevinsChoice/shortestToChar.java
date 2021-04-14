/*
821. Shortest Distance to a Character
https://leetcode.com/problems/shortest-distance-to-a-character/

아주 재밌는 문제 였다.
처음에는 split으로 금방끝낼거 같았지만... 잘 풀리지 않아ㅠ 역시 답을 보고 참고하였다
*/
class Solution {
    public int[] shortestToChar(String s, char c) {
       int len  = s.length(); // loveleetcode 의 길이
        int[] arr = new int[len]; // 결론 지을 배열
        int lastIdx = -1, nextIdx = s.indexOf(c);

        for (int i = 0; i < len; i++) {
            if(nextIdx > -1 && i > nextIdx) {
                lastIdx  = nextIdx;
                nextIdx = s.indexOf(c, i);
            }

            if(nextIdx > -1 && lastIdx > -1) {
                arr[i] = Math.min(i - lastIdx, nextIdx -i);
            }
            else if(lastIdx == -1)  {
                arr[i] = nextIdx - i;
            } else if(nextIdx == -1) {
                arr[i] = i - lastIdx;
            }
        }
        return arr;
    }
}
