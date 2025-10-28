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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = BuildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode BuildTree(int[] postorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[preEnd]);
        int inRoot = inMap.get(postorder[preEnd]);
        int numsLeft = inRoot - inStart;
        root.left = BuildTree(postorder, preStart, preStart + numsLeft-1, inorder, inStart, inRoot - 1, inMap);
        root.right = BuildTree(postorder, preStart + numsLeft, preEnd-1, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}
