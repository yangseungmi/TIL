/*
2. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

이 문제를 풀면서 ListNode 관련된 문제에 대해 확실히 자신감이 생겼고,
이젠 더이상 피하지 않으려고 한다. 그리고 이런 방식의 문제는 버퍼 ListNode를 두고 해결해 나가야 한다는
꿀팁도 알게 되었다!
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode out = new ListNode();           
        ListNode curr = out;
            
        boolean flag = false;
        int sum = 0;
        while(l1 != null || l2 != null){
            
            if(null == l1) sum = l2.val;
            
            else if(null == l2) sum = l1.val;
            
            else sum = l1.val + l2.val;
            
            if(flag) sum += 1;
            
            if(sum >= 10){
                flag = true;
            }
            else flag = false;

            ListNode node = new ListNode();
            
            node.val = sum % 10;
            
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;
            
            curr.next = node;
            curr = curr.next;
            
        }
        
        if(flag){// 마지막이 10이상이면
            curr.next = new ListNode(1);
        }
        
        return out.next;
    }
}
