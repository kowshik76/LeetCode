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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> ds=new LinkedList<TreeNode>();
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        if(root == null) return ans;
        ds.add(root);
        while(!ds.isEmpty()){
            int size=ds.size();
            List<Integer> subList=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=ds.poll();
                subList.add(node.val);
                if(node.left!=null) ds.add(node.left);
                if(node.right!=null) ds.add(node.right);
            }
            ans.add(subList);
        }
            return ans;
    }
}
