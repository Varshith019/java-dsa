/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public static ListNode collision(ListNode head1,ListNode head2,int d){
        ListNode t2 = head2;
        for(int i=0;i<d;i++){
            t2 = t2.next;
        }
        ListNode t1 = head1;
        while(t1!=t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;

    }
    public static int count(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count = count+1;
            temp = temp.next;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
            return null;
        }

        int n1 = count(headA);
        int n2 = count(headB);
        int d = Math.abs(n2-n1);
        return (n1 < n2)
        ? collision(headA, headB, d)
        : collision(headB, headA, d);
    }
}