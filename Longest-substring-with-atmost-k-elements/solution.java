class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hash=new HashMap<>();
        
        int l=0,r=0,maxlen=-1;
        while(r<s.length()){
            char c=s.charAt(r);
            hash.put(c,hash.getOrDefault(c,0)+1);
            if(hash.size()<=k){
                if(hash.size()==k){
                    
                maxlen=Math.max(maxlen,r-l+1);
                }
                r++;
            }else{
                if(hash.size()>k){
                
                    hash.put(s.charAt(l),hash.get(s.charAt(l))-1);
                    if(hash.get(s.charAt(l))==0){
                        hash.remove(s.charAt(l));
                    }
                    l++;
                }
                r++;
            }
            
        }
        return maxlen;
    }
}
