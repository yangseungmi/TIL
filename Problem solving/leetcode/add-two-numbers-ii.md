2019 10 2

https://leetcode.com/problems/add-two-numbers-ii/

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
    //두 Linked List의 합을 구해라
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //옮겨 담을 리스트 2개를 만들고
        ListNode pre1 = null;
        ListNode pre2 = null;
        
        //l1을 pre1에 하나씩 뒤로 땡겨서 복사(l2도)
        while(l1 != null){
            ListNode curr = l1.next;
            l1.next = pre1;
            pre1 = l1;
            l1 = curr;
        }
        while(l2 != null){
            ListNode curr = l2.next;
            l2.next = pre2;
            pre2 = l2;
            l2 = curr;
        }
        ListNode head1 = pre1;
        ListNode head2 = pre2;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int sum = 0;
        //pre1(head1) 또는 pre2(head2)가 null이 아닐 때
        while(head1 != null || head2 != null){
            sum /= 10;
            if(head1 != null){
                sum += head1.val;
                head1 = head1.next;
            }
            if(head2 != null){
                sum += head2.val;
                head2 = head2.next;
            }
            //dummy에 더한 값을 저장
            dummy.next = new ListNode( sum % 10 );
            //다음으로 이동
            dummy = dummy.next;
        }
        //더한 값이 10이상이면 next에 저장
        if(sum / 10 > 0){
            dummy.next = new ListNode(sum/10);
        }
        //head에 pre를 옮긴다(?)
        // 올림이 있어 자릿수가 하나더 생길 수 있어서 previous와 head로 나눔!!
        ListNode previous = null;
        ListNode head = pre.next;
        
        while(head!=null){
            ListNode curr = head.next;
            head.next = previous;
            previous = head;
            head = curr;
        }
        return previous;
    }
}


```

https://leetcode.com/problems/add-two-numbers-ii/discuss/92697/Easy-O(n)-Java-Solution-with-reversing-linked-lists
