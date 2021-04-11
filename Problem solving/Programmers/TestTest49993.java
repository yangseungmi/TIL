// 2021 4 11


/*
https://programmers.co.kr/learn/courses/30/lessons/49993
프로그래머스 스킬트리 문제
skill        "CBD"
skill_trees  ["BACDE", "CBADF", "AECB", "BDA"]
*/

package com.company.programmers;

public class Test49993 {
    public static void main(String[] args) {
        int n = solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println("CBD".contains("E"));
        System.out.println(n);
    }

    public static int solution(String skill, String[] skill_trees) {
        int index = 0;
        int answer = 0;
        while (true) {
            String st = skill_trees[index];
            String clone = new String(st);
            int size = st.length();
            for (int i = 0; i < size; i++) {
                String oneSkill = String.valueOf(clone.charAt(i));
                if (!skill.contains(oneSkill)) {
                    st = st.replace(oneSkill, "");
                }
            }
            if (skill.indexOf(st) == 0) {
                answer++;
            }
            index++;
            if (skill_trees.length == index) {
                break;
            }
        }
        return answer;
    }
}


// 참고 https://sas-study.tistory.com/342
