/*
92. Reverse Linked List II
https://leetcode.com/problems/reverse-linked-list-ii/

이건 처음부터 감이 안왔을뿐더러 ListNode에 대해 전혀 익히지 못한 나에게 매우 큰 좌절감과
봐도봐도 이해가 되지 않고, 클론코딩해봐도 도무지 내꺼가 되지 않는... 애증의 문제였다
매우 많은 시간을 투자해 이해하려고 노력했으나 결국 포기한 문제라 찝찝해 미치겠다ㅠ

알거같은데 자꾸 정신이 딴데로 샌다...

ListNode val, next
참고 https://im-developer.tistory.com/132

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
   public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || right == left) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left-1; i++) {
            prev = prev.next;
        } // 1,2,3 까지 넣어준다

        prev.next = doReverseBetween(prev.next, left, right);
        return dummy.next;
    }

    private static ListNode doReverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        for (int i = 0; i < n-m+1; i++) {
          // 이걸 이해하고 
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = next;
        return prev;

    }
}
