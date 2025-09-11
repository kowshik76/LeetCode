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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>  ans=new ArrayList<>();
        if(root == null ) return ans;
        FindPath(root ,"", ans);
        return ans;
    }
    public void FindPath(TreeNode node,String SubString,List<String> ans){
       if(node == null) return ;

       if(SubString.isEmpty() ){
        SubString+=node.val;
       }else{
        SubString+="->"+node.val;
       }
       if(node.left == null & node.right==null) {
        ans.add(SubString);
        return;
       }
       FindPath(node.left,SubString,ans);
       FindPath(node.right,SubString,ans);
    }
}

