class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
            if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l=j+1;
                int k=nums.length-1;
                while(l<k){
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if(sum>target){
                        k--;
                    }else if(sum<target){
                        l++;
                    }else{
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k--;
                        l++;
                        while(l<k && nums[l]==nums[l-1]) l++;
                        while(l<k && nums[k]==nums[k+1]) k--;
                    }
                }
            }
        }
        return ans;
    }
}
