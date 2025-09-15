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
 class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode _node,int _num){
        this.node=_node;
        this.num=_num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null ) return 0;
        int ans=0;
        Queue<Pair> ds=new LinkedList<>();
        ds.offer(new Pair(root,0));
        while(!ds.isEmpty()){
            int size=ds.size();
            int mmin=ds.peek().num;
            int first=0 ,last=0;
            for(int i=0;i<size;i++){
                int cur_id=ds.peek().num-mmin;
                TreeNode node=ds.peek().node;
                ds.poll();
                if(i==0) first=cur_id;
                if(i==size-1) last=cur_id;
                if(node.left != null){
                 ds.offer(new Pair(node.left,2*cur_id+1)); //segment trees idea 2*i+something
                }
                if(node.right!=null){
                    ds.offer(new Pair(node.right,2*cur_id+2));
                }
            }
                ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
