class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ds=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact*=i;
            ds.add(i);
        }
        ds.add(n);
        k=k-1;
        String ans="";
        while(true){
            ans=ans+ds.get(k/fact);
            ds.remove(k/fact);
            if(ds.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/ds.size();
        }
        return ans;
    }
}