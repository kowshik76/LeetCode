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
 class Node{
    int maxVal;
    int minVal;
    int maxSum;
    Node(int maxVal,int minVal,int maxSum){
        this.maxVal=maxVal;
        this.minVal=minVal;
        this.maxSum=maxSum;
    }
 }
class Solution {
    public Node maxSumBstHelper(TreeNode root){
        if(root == null){
            return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        Node left=maxSumBstHelper(root.left);
        Node right=maxSumBstHelper(root.right);
        if(left.maxVal < root.val && right.minVal > root.val){
            return new Node(Math.max(root.val,right.maxVal),Math.min(root.val ,left.minVal),left.maxSum + right.maxSum+root.val);
        }
        return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxSum,Math.max(right.maxSum,0)));
    }
    public int maxSumBST(TreeNode root) {
        return maxSumBstHelper(root).maxSum;
    }
}