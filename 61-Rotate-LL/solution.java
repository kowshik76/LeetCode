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
    public static ListNode FindNode(ListNode head,int k){
        ListNode temp=head;
        int count=1;
        while(temp.next!=null){
            if(k==count){
                break;
            }
            temp=temp.next;
            count++;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode tail=head;
        int count=1;
        while(tail.next!=null){
            count++;
            tail=tail.next;
        }
        if(k%count==0){
            return head;
        }
        k=k%count;
    tail.next=head;
    ListNode NewTail=FindNode(head,count-k);
     head=NewTail.next;
     NewTail.next=null;
     return head;
    }
}
