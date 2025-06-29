// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head==null || head.next==null) return null;
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
            if(temp==head){
                head=head.next;
                head.prev=null;
            }
                Node prev1=temp.prev;
                Node next1=temp.next;
                if(next1!=null) next1.prev=prev1;
                if(prev1!=null) prev1.next=next1;
                
            }
            temp=temp.next;
        }
        return head;
    }
}
