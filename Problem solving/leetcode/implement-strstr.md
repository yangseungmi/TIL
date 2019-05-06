2019 5 6

leetcode easy problem solving


https://leetcode.com/problems/implement-strstr/

```java
public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();//변수를 따로 선언하여 길이를 저장
        if (l1 < l2) {
            return -1;// 비교하는 needle 크기가 크면 -1로 출력
        } else if (l2 == 0) {//같으면 0으로 
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) { //차이만큼 for문
            if (haystack.substring(i,i+l2).equals(needle)) {//substring사용하여 비교하는 needle이 나오면 그 때 출력
                return i;
            }
        }
        return -1;
    }
}
```

좋은 코드가 있어 보면서 주석처리.
