/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void FindParents(TreeNode root, Map<TreeNode, TreeNode> parent_node) {
        Queue<TreeNode> parents = new LinkedList<>();
        parents.offer(root);
        while (!parents.isEmpty()) {
            TreeNode current = parents.poll();
            if (current.left != null) {
                parents.offer(current.left);
                parent_node.put(current.left, current);
            }
            if (current.right != null) {
                parents.offer(current.right);
                parent_node.put(current.right, current);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> ds = new LinkedList<>();
        Map<TreeNode, TreeNode> parent_node = new HashMap<>();
        FindParents(root, parent_node);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        ds.offer(target);
        int distance = 0;
        while (!ds.isEmpty()) {
        int size = ds.size();
            if (distance == k)
                break;
            distance++;
            for (int i = 0; i < size; i++) {
                TreeNode current = ds.poll();
                if (current.left != null && !visited.containsKey(current.left)) {
                    ds.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && !visited.containsKey(current.right)){
                    ds.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parent_node.get(current) != null && visited.get(parent_node.get(current)) == null) {
                    ds.offer(parent_node.get(current));
                    visited.put(parent_node.get(current), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!ds.isEmpty()) {
            TreeNode node = ds.poll();
            ans.add(node.val);
        }
        return ans;
    }
}
