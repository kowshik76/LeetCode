class Solution {
    public static Node mergeLL(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node res=dummy;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                res.bottom=list1;
                res=list1;
                list1=list1.bottom;
            }else{
                res.bottom=list2;
                res=list2;
                list2=list2.bottom;
            }
            res.next=null;
        }
        if(list1!=null) res.bottom=list1;
        if(list2!=null) res.bottom=list2;
        return dummy.bottom;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
    if(root==null || root.next==null){
        return root;
    }
     Node newHead=flatten(root.next);
    root=  mergeLL(root,newHead);
    return root;
    }
}
