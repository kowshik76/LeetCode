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
         public static ListNode FindKnode(ListNode head,int k){
        int count=1;
        while(count!=k && head!=null){
            head=head.next;
            count++;
        }
       return head;
    }
    public static ListNode ReverseLink(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
           ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){
            ListNode knode=FindKnode(temp,k);
            if(knode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                    break;
                }
            }
            ListNode nextNode=knode.next;
            knode.next=null;
           ListNode newHead= ReverseLink(temp);
            if(temp==head){
                head=newHead;
            }else{
                prevNode.next=newHead;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}
