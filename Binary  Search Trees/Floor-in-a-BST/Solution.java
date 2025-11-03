// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        Node curr=root;
        int val=-1;
        while(curr != null){
            if(x == curr.data){
                return curr.data;
            }else if(x < curr.data){
                curr=curr.left;
            }else{
                val=Math.max(val,curr.data);
                curr=curr.right;
            }
        }
        return val;
    }
}
