package Trees;
import java.util.*;

public class PreInPost {
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			left=right=null;
		}
		Node(int data ,Node left ,Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	static class Pair{
		Node first;
		int val;
		Pair(Node node,int val){
			this.first=node;
			this.val=val;
		}
	};
      public static void allTraversal(Node root) {
    		Stack<Pair> st=new Stack<>();
    		ArrayList<Integer> pre=new ArrayList<>();
    		ArrayList<Integer> in=new ArrayList<>();
    		ArrayList<Integer> post=new ArrayList<>();
    		st.push(new Pair(root,1));
    		while(!st.isEmpty()) {
    			Pair node=st.peek();
    			if(node.val==1) {
    				st.peek().val++;
    				pre.add(node.first.data);
    				if(node.first.left !=null) {
    					st.push(new Pair(node.first.left,1));
    				}
    			}
    			else if(node.val==2) {
    				st.peek().val++;
    				in.add(node.first.data);
    				if(node.first.right !=null) {
    					st.push(new Pair(node.first.right,1));
    				}
    			}
    			else {
    				post.add(node.first.data);
    				st.pop();
    			}
    		}
    		   System.out.print("Preorder Traversal: ");
    		      for (int i : pre) {
    		          System.out.print(i + " ");
    		      }
    		      System.out.println();

    		      // Printing Inorder
    		      System.out.print("Inorder Traversal: ");
    		      for (int i : in) {
    		          System.out.print(i + " ");
    		      }
    		      System.out.println();

    		      // Printing Postorder
    		      System.out.print("Postorder Traversal: ");
    		      for (int i : post) {
    		          System.out.print(i + " ");
    		      }
    		      System.out.println();
    		  
    		
      }

 


		public static void main(String[] args) {

	        // Creating the root
	        Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        root.right.left = new Node(6);
	        root.right.right = new Node(7);

	        // Function call
	        allTraversal(root);

	    }
}
