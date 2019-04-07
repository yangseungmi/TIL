2019 4 7

 아직 easy 문제도 허덕이고 있어
 오늘도 코드 주석 풀이..


https://leetcode.com/problems/middle-of-the-linked-list/submissions/

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int size = 1;  // 리턴노드 크기값 선언
        ListNode temp = head; //복사
        while(temp.next!=null){
            temp=temp.next;
            size++; //  head의 크기
        }
        int halfsize = (size/2) + 1; // head의 중간값
        while(halfsize>1){
            halfsize--; //중간 값의 -1만큼 자리이동
            head=head.next;
        }
        return head;
    }
}
```
