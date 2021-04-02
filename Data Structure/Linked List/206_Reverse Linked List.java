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
            tmp.next = node;        // tmp의 가장 앞에 있는 노드에 node 노드를 이어붙임(3-> (node) 2->1 ..)
            node = tmp;             // 현재의 tmp를 node로 (node : 3->2->1->null .. )
        }
        
        return node;
    }
}
