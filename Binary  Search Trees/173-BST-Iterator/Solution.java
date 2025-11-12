/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
       Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        st.push(root);
        Goleft(root.left);
    }
    
    public int next() {
        TreeNode val=st.pop();
        if(val.right != null) {
            Goleft(val.right);
        }
        return val.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void Goleft(TreeNode root){
        while(root != null){
            st.push(root);
            root=root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
