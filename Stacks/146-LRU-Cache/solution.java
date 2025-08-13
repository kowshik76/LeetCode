class Node{
    Node prev,next;
    int val,key;
    Node(int key1,int val1){
       this.val=val1;
       this.key=key1;
    }
}
class LRUCache {
    int capacity1;
    HashMap<Integer,Node> hash;
    Node head=new Node(0,0) , tail=new Node(0,0);
    public LRUCache(int capacity) {
        hash=new HashMap<>();
        head.next=tail;
        tail.prev=head;
        capacity1=capacity;
    }
    
    public int get(int key) {
        if(!hash.containsKey(key)) return -1;
        Node node=hash.get(key);
        DeleteEnd(node);
        AddFirst(node);
        return node.val;
    }
    
    public void AddFirst(Node node){
        hash.put(node.key,node);
        Node node1=head.next;
        head.next=node;
        node.prev=head;
        node.next=node1;
        node1.prev=node;

    }
   
    public void DeleteEnd(Node node){
        hash.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void put(int key, int value) {
        if(hash.containsKey(key)){
           DeleteEnd(hash.get(key));
        }
       if(hash.size()>= capacity1){
                DeleteEnd(tail.prev);
                }
            AddFirst(new Node(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
