/*
139. Word Break
https://leetcode.com/problems/word-break/

이건 거의 하루가 걸린 문제인데 어떻게해서든 내가 이해하고 넘어가고 싶었다.
결국 해결했고, 구글링해봐도 자기가 잘 간추려 쓴 코드만 딱 있을 뿐이지 제대로 설명도 없어
내가 해보기로 한다.
변수 네이밍도 멋져보이고 간단한게 아니라 알아듣기 쉽고, 바로 이해가 되는 변수명을 사용해 보기로한다.
미래의 토마스도 이해하기 쉽도록 :)

Array.asList("a","b","d","c")
new ArrayList<>(Arrays.asList("a", ...))
HashSet new HashSet<>(List) 변환 가능
String substing

*/
package com.company.leetcode;

import java.util.*;

public class WordBreak139 {

    public static void main(String[] args) {
        List<String> wordDict1 = new ArrayList<>(Arrays.asList("a", "b", "bbb", "bbbb")); // abab
        List<String> wordDict2 = new ArrayList<>(Arrays.asList("abc", "b", "cd", "a")); //abcd
        List<String> wordDict3 = new ArrayList<>(Arrays.asList("dog", "sand", "and", "cat", "cats")); //catsandog

        boolean result = wordBreak("catsandog", wordDict3);
        System.out.println(result);
    }


    public static boolean wordBreak(String s, List<String> wordDict) { // leetcode 변수명과 동일하게 사용

        // 인텔리제이에서 추천한 변수명도 좋다~
        HashSet<String> set = new HashSet<>(wordDict);
      
        int[] endCheck = new int[s.length() + 1]; // s의 1~길이 만큼이 들어가야 하기 때문
    
        endCheck[0] = 1; // 맨 앞이라 체크를 해둔다. 그래야 시작할 수 있음.

        // 이 for문은 검색하는 글자의 뒷문자 위치이다.  하나씩 늘어나면서 글자 끝까지 감.
        for (int end = 1; end <= s.length(); end++) {

            // 이 for문은 검색하는 글자의 앞문자 위치이다. 하나씩 늘어나면서 앞문자가 다음칸으로 간다.
            for (int start = 0; start < end; start++) {

                String sub = s.substring(start, end);
                int end_status = endCheck[start];

                // 예를 들어 end가 7일때,
                // s.substring(start, end)은 0~7, 1~7, 2~7, 3~4, 4~7, 5~7, 6~7 이렇게 찾는다
                // 그럼 값은 catsand, atsand, tsand, sand, and, nd, d 가 된다.

                if (set.contains(s.substring(start, end))) {

                    // 위 문자 중 sand와 and가 있어 if를 통화하면
                    // endCheck[start]를 확인한다. 여기서 'sand'의 start는 3, 'and'의 start는 4이다.

                    // endCheck[3]을 보면 
                    // cat이 통과했을 때 end가 3이었기 때문이다( substring(0,3) 0:c, 1:a, 2:t) )
                    // 앞에서 cat으로 endCheck[3]이 1이고, cats로 endCheck[4]도 1이다.

                    if (endCheck[start] == 1) {

                        // 따라서 end 7도 1이된다.
                        endCheck[end] = 1;
                        break;
                    }
                }

            }
        }
        /*
        * 쭉쭉쭉 endCheck를 1로 채워나가다 
        * 맨 마지막 글자까지 체크가 되었다는건 글자가 채워졌다는 뜻으로 true
        * */
        return endCheck[s.length()] == 1;
    }

}
