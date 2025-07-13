class Solution {
    public static void IsDup(int ind,int[] arr,List<List<Integer>> ans,ArrayList<Integer> ds){
        ans.add(new ArrayList(ds));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            ds.add(arr[i]);
            IsDup(i+1,arr,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
                    IsDup(0,nums,ans,new ArrayList<>());
    return ans;
    }
}