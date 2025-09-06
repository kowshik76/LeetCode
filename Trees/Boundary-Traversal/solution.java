/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    void addLeftBoundaries(Node node , ArrayList<Integer> ans){
        Node current=node.left;
        while(current != null){
        if(!isLeaf(current)) {
            ans.add(current.data);
        } 
        if(current.left != null ) current=current.left;
        else current=current.right;
        }
    }
    void addLeaves(Node node,ArrayList<Integer> ans){
            if(isLeaf(node)) {
                ans.add(node.data); 
                return;
            }
            if(node.left != null) addLeaves(node.left,ans);
            if(node.right != null) addLeaves(node.right,ans);
    }
    void addRightBoundaries(Node node , ArrayList<Integer> ans){
        Stack<Integer> st=new Stack<>();
        Node current=node.right;
        while(current != null ){
            if(!isLeaf(current)) st.push(current.data);
            if(current.right != null) current=current.right;
            else current=current.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
    }
    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        if(node == null) return ans;
        if(! isLeaf(node)) ans.add(node.data);
        
        addLeftBoundaries(node,ans);
        addLeaves(node , ans);
        addRightBoundaries(node , ans);
        return ans;
    }
}
