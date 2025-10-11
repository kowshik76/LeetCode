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
    public TreeNode Binary2mpp(TreeNode root, int start, HashMap<TreeNode, TreeNode> mpp) {
        Queue<TreeNode> ds = new LinkedList<>();
        ds.offer(root);
        TreeNode res = null;
        while (!ds.isEmpty()) {
            TreeNode node = ds.poll();
            if (node.val == start)
                res = node;
            if (node.left != null) {
                mpp.put(node.left, node);
                ds.offer(node.left);
            }
            if (node.right != null) {
                mpp.put(node.right, node);
                ds.offer(node.right);
            }
        }
        return res;
    }

    public int findmaxi(HashMap<TreeNode, TreeNode> mpp,
            TreeNode target) {
        HashMap<TreeNode, Integer> visited = new HashMap<>();
        visited.put(target, 1);
        Queue<TreeNode> ds = new LinkedList<>();
        ds.offer(target);
        int maxi = 0;
        while (!ds.isEmpty()) {
            int fl = 0;
            int size = ds.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = ds.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    fl = 1;
                    visited.put(node.left, 1);
                    ds.offer(node.left);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    fl = 1;
                    visited.put(node.right, 1);
                    ds.offer(node.right);
                }
                if (mpp.get(node) != null && visited.get(mpp.get(node)) == null) {
                    fl = 1;
                    visited.put(mpp.get(node), 1);
                    ds.offer(mpp.get(node));
                }
            }
            if (fl == 1)
                maxi++;
        }
        return maxi;
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode target = Binary2mpp(root, start, mpp);
        int maxi = findmaxi(mpp, target);
        return maxi;
    }
}
