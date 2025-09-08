/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/
class Tuple{
    Node node;
    int col;
    public Tuple(Node _node,int _col){
        this.node=_node;
        this.col=_col;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root == null ) return ans;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        Queue<Tuple> ds=new LinkedList<>();
        ds.offer(new Tuple(root,0));
        while(!ds.isEmpty()){
            Tuple tuple=ds.poll();
            Node node=tuple.node;
            int x=tuple.col;
            if(map.containsKey(x)){
                map.remove(x);
                map.put(x,node.data);
            }else{
                map.put(x,node.data);
            }
            if(node.left != null) ds.offer(new Tuple(node.left,x-1));
            if(node.right != null) ds.offer(new Tuple(node.right,x+1));
        }
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            ans.add(mp.getValue());
        }
        return ans;
        
    }
}
