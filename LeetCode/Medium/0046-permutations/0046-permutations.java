class Solution {
    public static void perm(ArrayList<Integer> ds,List<List<Integer>> ans,HashMap<Integer,Integer> hash,int[] arr){
        if(ds.size()==arr.length){
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!hash.containsKey(arr[i])){
                ds.add(arr[i]);
                hash.put(arr[i],1);
                perm(ds,ans,hash,arr);
                ds.remove(ds.size()-1);
                hash.remove(arr[i]);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> ds=new ArrayList<>();
        perm(ds,ans,hash,nums);
        return ans;
    }
}