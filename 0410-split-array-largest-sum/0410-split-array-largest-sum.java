class Solution {
    public boolean ispossible(int[] nums, int k, int mid) {
        int sum = 0;
        int k1 = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (sum + val <= mid) {
                sum += val;
            } else if (sum + val >= mid) {
                sum = val;
                
                k1++;
            }
            if(k1>k){
                return false;
            }
        }
        return true ;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int val : nums) {
            l = Math.max(l, val);
            r += val;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ispossible(nums, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}