class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        int xor=0;
        long count=0;
        for(int i=0;i<arr.length;i++){
             xor=xor^arr[i];
             int xr=xor^k;
             if(hs.containsKey(xr)){
                 count+=hs.get(xr);
             }
                 hs.put(xor,hs.getOrDefault(xor,0)+1);
             
        }
        return count;
    }
}
