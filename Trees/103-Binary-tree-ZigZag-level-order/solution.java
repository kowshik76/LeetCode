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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> ds=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root == null) return ans;
        ds.add(root);
        boolean isLeft=true;
        while(!ds.isEmpty()){
            int size=ds.size();
            List<Integer> subList=new ArrayList<>(Collections.nCopies(size, 0));
            for(int i=0;i<size;i++){
                TreeNode node=ds.poll();
                int index= (isLeft) ? i : (size-1-i);
                subList.set(index , node.val) ;
                if(node.left != null ) ds.add(node.left);
                if(node.right != null ) ds.add(node.right);
            }
            isLeft=!isLeft;
            ans.add(subList);
        }
        return ans;
    }
}
