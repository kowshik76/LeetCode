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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        right(root , 0 , ans);
        return ans;
    }
    public void right(TreeNode node , int level , List<Integer> ans){
        if(node == null) return;
        if(level == ans.size()) ans.add(node.val);
        if(node.right!=null) right(node.right,level+1,ans);
        if(node.left!=null) right(node.left,level+1,ans);
    }
}
