class Solution {
    public static int maxi(int[] arr){
        int maxim=0;
        for(int i=0;i<arr.length;i++){
            maxim=Math.max(maxim,arr[i]);
        }
        return maxim;
    }
    public int characterReplacement(String s, int k) {
        int maxlen=0;
        int l=0,r=0;
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(r)-'A']+=1;
            while((r-l+1)-maxi(hash)>k){
                hash[s.charAt(l)-'A']-=1;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}
