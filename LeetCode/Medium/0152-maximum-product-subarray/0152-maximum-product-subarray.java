class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            maxi = Math.max(product, maxi);
            if (product == 0)
                product = 1;
        }
                product = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            product *= nums[i];
            maxi = Math.max(product, maxi);
            if (product == 0)
                product = 1;
        }
        return maxi;
    }
}