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
 public static ListNode reverseLL(ListNode head){
    ListNode temp=head;
    if(temp==null || temp.next==null){
        return temp;
    }
    ListNode newNode=reverseLL(temp.next);
    ListNode front=temp.next;
    front.next=temp;
    temp.next=null;
    return newNode;
 }
    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
             slow=slow.next;
             fast=fast.next.next;
        }
        ListNode newHead=reverseLL(slow.next);
        ListNode first=head;
        ListNode second=newHead;
        while(second!=null){
            if(first.val !=second.val){
                // reverseLL(newHead); //reverse the second half into its original form for the   interview sake
                return false;
            }
            first=first.next;
            second=second.next;
        }
        //  reverseLL(newHead);//reverse the second half into its original form for the interview sake
        return true;
    }
}