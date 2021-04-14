/*
56. Merge Intervals
https://leetcode.com/problems/merge-intervals/

재밌는 문제였다. 처음에 그냥 Array로 할 수 있을줄 알고 조건 추가추가 하다보며 맞춰나가다가
아니다 를 깨닫고 블로그 글을 보고 다시 풀었다...


int[] newInterval = intervals[0];
list.add(newInterval); 이렇게 List안에 배열 값을 넣은뒤
newInterval의 값을 바꾸면 list에 넣은 값이 바뀐다는걸 오늘 알게되었다.
그닥 좋은 방법인지는 모르겠지만 다른 Map이나 LinkedList 사용한 방법도 같이 공부해 놓아야겠다.

Arrays.sort, LinkedList, LinkedList.getLast() - 맨 마지막 값(newInterval를 안 써도 됬었넹)
Array foreach - 좀 

참고 https://kyungseop.tistory.com/13
*/

import java.util.Arrays;

class Solution {
  
  
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }

            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
  
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (o1, o2) ->
            Integer.compare(o1[0],o2[0])
        );

        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0]; // 처음꺼 넣어주고
        list.add(newInterval);
        for (int[] interval : intervals) {
            if(interval[0] <= newInterval[1]){ // 기존의 앞, 다음의 뒤
                newInterval[1] = Math.max(newInterval[1], interval[1]);

            }
            else if(interval[0] > newInterval[1]) { // 6 > 3
                newInterval = interval;
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
