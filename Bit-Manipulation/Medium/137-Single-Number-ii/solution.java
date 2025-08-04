class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int num=1;num<nums.length;num+=3){
            if(nums[num]!=nums[num-1]){
                return nums[num-1];
            }
        }
        return nums[nums.length-1];
    }
}
