2019 4 8


아직 easy인 문제들이지만
혼자 풀이 안보고 하면서 조만간 난이도를 더 높여보는걸로 ㅎㅎ

https://leetcode.com/problems/flipping-an-image/

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int size = A[0].length;
        int half = size /2;
        int[][] ret = new int[size][size];
        
        
        for(int j=0;j<size;j++){
            int s = size;
            for(int k=0;k<size;k++){
                ret[j][k] = A[j][s-1];
                s--;
            }
        }
        
        for(int j=0;j<size;j++){
            for(int k=0;k<size;k++){
                ret[j][k] = reverse(ret[j][k]);
            }
        }
        return ret;
        
    }
    
    
    public int reverse(int n){
        if(n == 0) return 1;
        else return 0;
    }
}
```




