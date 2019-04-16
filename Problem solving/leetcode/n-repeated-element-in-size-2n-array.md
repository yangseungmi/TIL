2019 4 17

leetcode easy problem n-repeated-element-in-size-2n-array

문제 풀이 시간이 점점 짧아지고 있다!

5월에는 mideum 문제를 풀 수 있도록 더 연습해야 할 거 같다.

https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

```java
class Solution {
    public int repeatedNTimes(int[] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(i !=j && A[i] == A[j]){
                    return A[i];
                }
            }
        }
        return 0;
    }
}
```



