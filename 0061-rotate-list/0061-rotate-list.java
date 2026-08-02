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
    public static ListNode find(ListNode head,int k){
        ListNode temp = head;
        for(int i=0;i<k-1;i++) {
            temp = temp.next;
        }
        System.out.print(temp.val);
        return temp;

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            tail= tail.next;
            len++;
        }
        
        if(k%len==0) {
           return head;
        }
        k = k%len;
        tail.next = head;
        ListNode lastnode = find(head,len-k);
        head = lastnode.next;
        lastnode.next = null;
        
        return head;
    }
}