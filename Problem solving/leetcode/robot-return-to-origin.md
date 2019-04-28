2019 4 29

알고리즘 쉬운 문제를 풀어보았다 ㅎㅎ

https://leetcode.com/problems/robot-return-to-origin/

```java
class Solution {
    public boolean judgeCircle(String moves) {
        
        int x = 0, y =0;
        for (char move: moves.toCharArray()) {
            if(move == 'U') y ++;   
            else if(move == 'D') y --;    
            else if(move == 'L') x --;    
            else if(move == 'R') x ++;
        }
        
        if(x == 0 && y == 0) return true;
        else return false;
    }
}
```
