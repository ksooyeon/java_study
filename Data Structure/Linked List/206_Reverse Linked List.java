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
    public ListNode reverseList(ListNode head) {
        
        ListNode node = null;
        
        while(head != null){
            ListNode tmp = head;    // tmp = 현재 head ListNode로 초기화
            head = head.next;       // head는 다음 노드부터 시작하는 ListNode로 초기화
            tmp.next = node;        // 뒤로 보낼 tmp의 앞 부분을 node에 저장
            node = tmp;             // 현재의 tmp를 node로 
        }
        
        return node;
    }
}
