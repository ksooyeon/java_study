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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; //이미 정렬
        
        // 1. 리스트를 반으로 나누기
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            temp = slow;       // 왼쪽 리스트의 끝
            slow = slow.next;  // 오른쪽 리스트 시작
            fast = fast.next.next;  // 오른쪽 리스트 끝
        }
        
        temp.next = null;
        
        // 2. 각각의 리스트를 정렬하기
        ListNode left_side = sortList(head);  // head : 왼쪽 리스트 시작
        ListNode right_side = sortList(slow);
        
        // 3. 정렬된 리스트 합치기
        return merge(left_side, right_side);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode sorted_temp = new ListNode(0);
        ListNode current_node = sorted_temp;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current_node.next = l1;
                l1 = l1.next;
            }
            else{
                current_node.next = l2;
                l2 = l2.next;
            }
            
            current_node = current_node.next;
        }
        
        if(l1 != null){
            current_node.next = l1;
            l1 = l1.next;
        }
        
        if(l2 != null){
            current_node.next = l2;
            l2 = l2.next;
        }
        
        return sorted_temp.next;
    }
}
