/*
253. Min Meeting Rooms 2
https://leetcode.com/problems/meeting-rooms-ii/

이 소스의 정답을 보고 훌륭함을 금치 못했다.
이걸 짠 개발자는 과연 몇분만에 만들었을까... 생각을 해보기도 하고
나도 언제쯤 이런 코드를 짤 수 있을까.. 잠시 멍 때렸다 ㅋㅋ
이런 문제 케이스를 회사 입사 전 코테로 많이 출제 되는걸 뼈져리게 경험했고,
솔직히 말하면 다시 풀으라고 해도 자신이 없다...

그래도 이 문제를 통해 한걸음 성장했을거라고 믿고 다음 문제로 넘어간다ㅠ

Arrays.sort(int[][], Comparator.comparing(each -> each[0])
targetIndex를 사용해서 교체.

*/
package com.company.leetcode;

import java.util.Arrays;
import java.util.*;

public class MeetingRoom253 {
    public static void main(String[] args) {
        int[][] intervals = {
                {0,30},{5,10},{15,20},{35,36},{37,38}
        };
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int[][] intervals) {
        //정렬
        Arrays.sort(intervals, Comparator.comparing(each -> each[0]));
        List<Integer> ends = new ArrayList<>();
        //비교
        for (int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int targetIndex = -1;
            for (int j=0; j<ends.size(); j++) {
                if (start >= ends.get(j)) {
                    targetIndex = j;
                    break;
                }
            }

            if (targetIndex != -1) {
                ends.set(targetIndex, end);
            } else {
                ends.add(end);
            }
        }


        return ends.size();
    }
}
