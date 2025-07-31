class Solution {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int left=1,right=1;
        for (int i = 0; i < nums.length; i++) {
            if(left==0) left=1;
            if(right==0) right=1;
            left *= nums[i];
            right *= nums[nums.length-i-1];
            maxi = Math.max(maxi,Math.max(right,left));
        }
        return maxi;
    }
}