2019 4 3


leetcode 쉬운 문제인줄 알았지만
짧은 시간안에도 못풀고 결국 다른 solution을 보고 맘에 드는 소스 주석으로 설명...

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry; //맨 끝에 자리 수 plus one
            if (digits[i] <= 9) //9이 하면 그래도 결과 출력
                return digits;
            digits[i] = 0; //   10이면 맨 끝에 자리 수를 0으로 하고
        }
        int[] ret = new int[digits.length+1]; //배열 크기 하나 더 늘리고
        ret[0] = 1;       // 맨 끝에 자리 수를 1로 출력
        return ret;
    }
}
```
