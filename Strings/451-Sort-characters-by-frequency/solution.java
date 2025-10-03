class Node{
    char a;
    int frequency;
    Node(char a,int frequency){
        this.a=a;
        this.frequency=frequency;
    }
}
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> hs=new HashMap<>();
        for(char c : s.toCharArray()){
            hs.put(c,hs.getOrDefault(c,0)+1);
        }
        PriorityQueue<Node> pr=new PriorityQueue<>((a,b)->b.frequency-a.frequency);
        for(Map.Entry<Character,Integer> entry : hs.entrySet()){
            pr.add(new Node(entry.getKey(),entry.getValue()));
        }
        while(!pr.isEmpty()){
            Node temp=pr.poll();
            for(int i=0;i<temp.frequency;i++){
                sb.append(temp.a);
            }
        }
        return sb.toString();
    }
}
