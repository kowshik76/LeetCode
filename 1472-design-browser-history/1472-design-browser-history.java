class ListNode{
    String data;
    ListNode next,prev;
 ListNode(String data){
    this.data=data;
    this.next=null;
    this.prev=null;
 }
}
class BrowserHistory {
    ListNode current;
    public BrowserHistory(String homepage) {
         current=new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode newNode=new ListNode(url);
        current.next=newNode;
        newNode.prev=current;
        current=current.next;
    }
    
    public String back(int steps) {
        while(steps>0){
            if(current.prev!=null){
            current=current.prev;
            steps--;
            }else{
                break;
            }
        }
        return current.data;
    }
    
    public String forward(int steps) {
        while(steps>0){
            if(current.next!=null){
            current=current.next;
            steps--;
            }else{
                break;
            }
        }
        return current.data;
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */