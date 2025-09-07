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
public class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode _node, int _col, int _row) {
        this.node = _node;
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> ds = new LinkedList<Tuple>();
        ds.offer(new Tuple(root, 0, 0));
        while (!ds.isEmpty()) {
            Tuple tuple = ds.poll();
            TreeNode node = tuple.node;
            int x = tuple.col;
            int y = tuple.row;
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if (node.left != null)
                ds.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                ds.offer(new Tuple(node.right, x + 1, y + 1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            ans.add(col);
        }
        return ans;
    }
}
