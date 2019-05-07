2019 5 7

https://leetcode.com/problems/array-partition-i/

```java
class Solution {
    public int arrayPairSum(int[] nums) {
        int size = nums.length;
        int s =0;
        /*
            for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(nums[i] > nums[j]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        */
        
        Arrays.sort(nums);
        for(int k =0;k<size;){
            if(nums[k] < nums[k+1]) s += nums[k];
            else s+= nums[k+1];
            k = k+2;
        }
        return s;
    }
}
```
