/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int helpme(Node head){
        Node temp=head;
        if(temp==null){
            return 1;
        }
       int carry=helpme(temp.next);
        temp.data=temp.data+carry;
        if(temp.data<10){
            return 0;
        }
        temp.data=0;
        return 1;
    }
    public Node addOne(Node head) {
        Node temp=head;
        int carry=helpme(temp);
        if(carry==1)
        {
            Node newNode=new Node(1);
            newNode.next=head;
            return newNode;
        }
        return head;
    }
}
