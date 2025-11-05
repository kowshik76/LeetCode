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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null ){
            return null;
        }
        if(root.val==key) return helper(root);
        TreeNode curr=root;
        while(curr != null ){
            if(curr.val > key ){
                if(curr.left != null && curr.left.val == key){
                    curr.left=helper(curr.left);
                    break;
                }else{
                    curr=curr.left;
                }
            }else{
                if(curr.right != null && curr.right.val == key){
                    curr.right=helper(curr.right);
                    break;
                }else{
                    curr=curr.right;
                } 
            }
        }
        return root;
    }
    public static TreeNode helper(TreeNode node){
        if(node.left == null){
            return node.right;
        }else if(node.right ==null){
            return node.left;
        }else{
            TreeNode rights=node.right;
            TreeNode rightMost=GetRightMost(node.left);
            rightMost.right=rights;
            return node.left ;
        }
    }
    public static TreeNode GetRightMost(TreeNode node){
        if(node.right == null ){
            return node;
        }
        return GetRightMost(node.right);
    }
}
