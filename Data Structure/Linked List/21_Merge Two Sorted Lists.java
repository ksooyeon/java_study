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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result = new ListNode();
        ListNode current = result;       // 결과가 result의 head에 저장  
        
        while(l1 != null && l2 != null){    // l1과 l2 값 중 작은 것 current에 저장  
            if(l1.val < l2.val){ 
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            
            current = current.next;
        }
        
        if(l1 == null)
            current.next = l2;
        if(l2 == null)
            current.next = l1;
        
        return result.next;     // result의 헤드가 0이므로 next 리턴
    }
} 
