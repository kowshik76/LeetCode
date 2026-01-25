class Solution {
    public int minimumDifference(int[] nums, int k) {
        int mindif=Integer.MAX_VALUE;
        int l=0,r=0;
        Arrays.sort(nums);
        while(r< nums.length){
            if(r-l+1 == k){
                mindif=Math.min(mindif,Math.abs(nums[l]-nums[r]));
                l++;
            }
            r++;
        }
        return mindif;
    }
}
