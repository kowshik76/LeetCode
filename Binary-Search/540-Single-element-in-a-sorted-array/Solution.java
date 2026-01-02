class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        int l=1;
        int r=nums.length-2;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid] != nums[mid +1] && nums[mid] != nums[mid-1]) return nums[mid];
            if((mid % 2 ==1 && nums[mid] == nums[mid-1] ) || ( mid % 2 == 0 && nums[mid] == nums[mid+1])){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}
