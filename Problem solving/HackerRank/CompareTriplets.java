/*
CompareTriplets
https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true

해커랭크 코딩테스트 사이트 문제를 풀어보았다.
가장 기초적인? 쉬운 난이도의 문제로 시작했고, 프로그래머스와 크게 다른점은 없었지만 language가 다른 점(제일큰차이)
말고는 비슷했다. 나중에 git 연동도 된다니 더욱 친해져 볼 사이트이다.

이 문제를 통해 List와 좀 더 친해진거 같다.
문제를 보자마자 당연히 [] 배열인 줄 알고 a[i]를 넣었다가 아차차 했다 :)
List로 여러가지 방법을 사용해서 풀 수 있는 문제였다.

List
*/
class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets1(List<Integer> a, List<Integer> b) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        answer.add(0);answer.add(0);
        for(int i = 0; i< a.size(); i++) {
            if(a.get(i) > b.get(i)) 
              answer.set(0, answer.get(0)+1);
            if(a.get(i) < b.get(i)) 
              answer.set(1, answer.get(1)+1);
        }
         return answer;
    }


    public static List<Integer> compareTriplets2(List<Integer> a, List<Integer> b) {
       // Write your code here
       int aliceCnt = 0, bobCnt = 0;
        for(int i = 0; i< a.size(); i++) {
            if(a.get(i) > b.get(i)) aliceCnt++;
            if(a.get(i) < b.get(i)) bobCnt++;
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(aliceCnt);
        answer.add(bobCnt);
        return answer;
    }
}
