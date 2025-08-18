class Node {
    int key, value, freq;
    Node prev, next;
    Node(int k, int v) {
        this.key = k;
        this.value = v;
        freq = 1; // every new node starts with frequency 1
    }
}
class DoublyLinkedList {
    Node head, tail;
    int size;
    DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
     public void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }
     public void removeNode(Node node) {
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        size--;
    }
     
}
class LFUCache {
  int capacity, minfreq;
  int cursize;
    Map<Integer, Node> nodeMap;               // key → Node
    Map<Integer, DoublyLinkedList> freqmap;
    public LFUCache(int capacity) {
          this.capacity = capacity;
        nodeMap = new HashMap<>();
        freqmap = new HashMap<>();
        this.minfreq = 0;
        this.cursize=0;
    }
    
    public int get(int key) {
         if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(nodeMap.containsKey(key)){
            Node curNode=nodeMap.get(key);
            curNode.value=value;
            update(curNode);
        }else{
            if(cursize >= capacity){
                DoublyLinkedList minfreqList=freqmap.get(minfreq);
                nodeMap.remove(minfreqList.tail.prev.key);
                minfreqList.removeNode(minfreqList.tail.prev);
                cursize--;
            }
            minfreq=1;
            Node newNode=new Node(key,value);
            DoublyLinkedList newList=freqmap.getOrDefault(minfreq,new DoublyLinkedList());
            cursize++;
            nodeMap.put(key,newNode);
            newList.addNode(newNode);
            freqmap.put(minfreq,newList);
        }
    }
    public void update(Node node){
        int curfreq=node.freq;
        DoublyLinkedList newList=freqmap.get(curfreq);
        newList.removeNode(node);
        if(curfreq == minfreq && newList.size ==0){
            minfreq++;
        }
        node.freq++;
        DoublyLinkedList curlist=freqmap.getOrDefault(node.freq,new DoublyLinkedList() );
        curlist.addNode(node);
        freqmap.put(node.freq,curlist);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
