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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head : lists) {
            if(head!=null) {
                minHeap.add(head);
            }
        }
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
                while(!minHeap.isEmpty()) {
                   ListNode node =  minHeap.poll();
                   current.next = node;
                   current = current.next;
                if(node.next!=null) {
                    minHeap.add(node.next);
                 }
                }
                return dummy.next;
            }
        }
