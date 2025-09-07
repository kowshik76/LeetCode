/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
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
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null ) return ans;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> ds=new LinkedList<Tuple>();
        ds.offer(new Tuple(root,0));
        while(!ds.isEmpty()){
            Tuple tuple=ds.poll();
           int x=tuple.col;
            Node temp=tuple.node;
            if(map.get(x)==null ) map.put(x , temp.data);
            if(temp.left != null) ds.offer(new Tuple(temp.left,x-1));
            if(temp.right!=null) ds.offer(new Tuple(temp.right , x+1 ));
        }
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){
            ans.add(mp.getValue());
        }
        return ans;
    }
}
