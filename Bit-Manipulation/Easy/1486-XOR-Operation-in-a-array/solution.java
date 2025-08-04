class Solution {
    public int xorOperation(int n, int start) {
        int xor=0;
        int ans=0;
        for(int i=0;i<n;i++){
            xor=2*i;
            xor+=start;
            ans=ans^xor;
        }
        return ans;
    }
}
