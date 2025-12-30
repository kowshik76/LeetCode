class Solution {
    public boolean search(int[] nums, int target) {
         int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[l] && nums[mid] == nums[r]){
                l=l+1;
                r=r-1;
                continue;
                
            }
            if(nums[l]<= nums[mid]){
                if(nums[l] <= target && nums[mid] >= target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[r] >= target && nums[mid] <=target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}
