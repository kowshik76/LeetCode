/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        // add code here.
        int successor=-1;
        while(root != null){
            if(root.data > x.data){
                successor=root.data;
                root=root.left;
            }else if(root.data == x.data){
                root=root.right;
            }else{
                root=root.right;
            }
        }
        return successor;
    }
}
