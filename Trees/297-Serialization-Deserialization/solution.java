/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("# ").append(" ");
                continue;
            }
            sb.append(node.val).append(" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split("\\s+");
        if (arr.length == 0 || arr[0].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode parent = q.poll();
            // left
            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            // right
            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
