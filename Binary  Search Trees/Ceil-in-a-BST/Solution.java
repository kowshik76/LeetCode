/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // code here
        Node curr=root;
        int val=-1;
        while(curr != null){
            if(x == curr.data){
                val=curr.data;
                return val;
            }else if(curr.data > x){
                val=curr.data;
                curr=curr.left;
            }else{
                curr=curr.right;
                
            }
        }
        return val;
    }
}
