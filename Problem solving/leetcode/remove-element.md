2019 3 31

#### 오늘도 간단한 leetcode 문제 풀기
##### https://leetcode.com/problems/remove-element/

***
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
***
처음에 무턱대고 생각나는대로 짰는데 내가 int[] 를 하나 더 선언해서 
for문으로 그 안에 넣고 하려고 했었다.   후ㅜ
그럴필요는 없지만 그렇게도 할 수 있을거 같았고
나는 개발자이기 때문에 간단한 방법이 떠오르자 
소스를 지웠다. 

앞으로 문제를 집중해서 읽고 코드를 짜기 시작하는 버릇을 들여야 할 것 


```java
class Solution {
    public int removeElement(int[] nums, int val) {
        
        int a = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[a] = nums[i];
                a++;
            }
        }
        return a;
    }
}
```

