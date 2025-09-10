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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null  || isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode right , TreeNode left){
        if(right == null || left == null ) return right==left;
        if(left.val != right.val) return false;
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }
}
