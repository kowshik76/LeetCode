/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public static Node InsertNode(Node head){
        Node temp=head;
        while(temp!=null){
            Node element=temp.next;
            Node copy=new Node(temp.val);
            copy.next=element;
            temp.next=copy;
            temp=element;
        }
        return head;
    }
    public static Node InsertRandom(Node head){
        Node temp=head;
        while(temp!=null){
            Node copy=temp.next;
            if(temp.random!=null){
                copy.random=temp.random.next;
            }else{
                copy.random=null;
            }
            temp=temp.next.next;
        }
        return head;
    }
    public static Node removeLink(Node head){
        Node temp=head;
        Node dummy=new Node(-1);
        Node res=dummy;
        while(temp!=null){
            res.next=temp.next;
            res=temp.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
     InsertNode(head);
     InsertRandom(head);
     return removeLink(head);
    }
}