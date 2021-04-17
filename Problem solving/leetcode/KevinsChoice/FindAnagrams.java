/*
438. Find All Anagrams in a String
https://leetcode.com/problems/find-all-anagrams-in-a-string/

이 문제를 보고 substring이 바로 생각났지만
HashTable 흰트를 보고 하나씩 넣어서 술술 풀리는가 했다..
하지만 문자가 긴 경우 'Time Limit Exceeded'이 발생 했고, 
String을 toCharArray()로 바꾼뒤 정렬 sort해서 String.valueOf로 비교했다.

sort보다 time limit이 더 제약이 큰걸 깨닫고 앞으로 sort를 더 잘 활용해야겠다는 생각을 했다.

char[] ch = String.toCharArray();
Arrays.sort(ch);
// bca -> abc

비교는 이렇게
if(String.valueOf(ch).equals(String.valueOf(sub)))

*/
package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class FindAnagrams438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        //String s = "baa", p = "aa";
        System.out.println("size:" + findAnagrams(s, p).size());
    }

  
  
  
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> cnt = new ArrayList<>();
        int len = p.length();
        char[] ch = p.toCharArray();
        Arrays.sort(ch);

        for (int i = 0; i < s.length() - len + 1; i++) {
            char[] sub = s.substring(i, i + len).toCharArray();
            Arrays.sort(sub);
            if(String.valueOf(ch).equals(String.valueOf(sub))){
                cnt.add(i);
            }
        }
        return cnt;
    }

  
  
  
    public static List<Integer> findAnagrams1(String s, String p) {

        //String s = "cbaebabacd", p = "abc";
        List<Integer> list = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();

        int[] anagram = new int[26];
        for (int i = 0; i < pl; i++) {
            anagram[p.charAt(i) - 'a']++;
            anagram[s.charAt(i) - 'a']++;
        }
        if(allZero(anagram)){
            list.add(0);  // 값이 없는게 있으면
        }
        for (int i = 1; i < sl; i++) {
            anagram[s.charAt(i)-'a']--;
            anagram[s.charAt(i - pl) - 'a']++;
            if(allZero(anagram)){
                list.add(i-pl+1);
            }
        }
        return list;
    }

    private static boolean allZero(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }

}
