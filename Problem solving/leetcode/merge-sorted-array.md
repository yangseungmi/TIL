2019 04 12

merge-sorted-array !! 

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        if(m != 0 || n != 0){

            for(int i=0;i<size;i++){
                if(i>=m){
                    nums1[i] = nums2[i-m];
                }
            }
        }
        for(int k=0;k<size;k++){
           for(int j=k+1;j<size;j++){
               if(nums1[k] >nums1[j]){
                   int tmp =0;
                   tmp = nums1[k];
                   nums1[k] = nums1[j];
                   nums1[j] = tmp;
                }
           }
        }
    }
}
```
