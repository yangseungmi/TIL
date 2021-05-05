/*
DiagonalDifference
https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=false


List<List<Integer>> List에 List라니... 
3
11 2 4
4 5 6
10 8 -12
이 input에 대각선 끼리의 gab을 구하는 문제였다.. input이 arr에 어떻게 넘어오는지 감이 안잡혀 다른 분 소스를 보았는데
아직도 사실 잘 이해가 되지는 않는다 ;;
그리고 나의 네이밍 실력이 전혀 향상되지 않는다는걸 또 한번 새삼 깨달았다...
참고한 블로그의 개발자 분 네이밍을 보고 감탄했고,
네이밍에 시간을 충분히 갖고(영어공부 절실..) 한눈에 파악하기 쉬운 변수명을 만드는 습관을 길러야겠다.

List
*/
public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
    int size = arr.size();
    int s1 = 0, s2 = 0;
    int tmp = size-1; // 3
    for (int i = 1; i < size; i++) {
        List<Integer> list = arr.get(i);
        s1 += list.get(tmp);
        s2 += list.get(i);
        tmp--;
    }
    return Math.abs(s1 - s2);
}

public static int diagonalDifference2(List<List<Integer>> arr) {
    int array_size = arr.size();
    int sum_l_to_r = 0; // left to right
    int sum_r_to_l = 0;
    for (int i = 0; i < array_size; i++) {
        sum_l_to_r += arr.get(i).get(i);
        sum_r_to_l += arr.get(i).get(array_size - i - 1);
    }
    return Math.abs(sum_l_to_r - sum_r_to_l);
}
