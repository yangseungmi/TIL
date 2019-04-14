2019 4 14


https://leetcode.com/problems/di-string-match/

문제


```
Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:
```

풀이

```java
class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] A = new int[N+1];
        String str = "";
        int a1 = 0, a2 = N; 
        for(int i = 0; i<N; i++){
            str = S.substring(i,i+1);
                if(str.equals("I")){
                    A[i] = a1;
                    a1++;
                }
                else if(str.equals("D")){
                    A[i] = a2;
                    a2--;
                }
        }
        A[N] = a1;
        return A;
    }
}
```
