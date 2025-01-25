class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
           int complement=target-nums[i];
           if(hash.containsKey(complement)){
              return new int[] {hash.get(complement),i}; 
           }else{
            hash.put(nums[i],i);
           }

        }

        return new int[] {}; // No solution found
    }
}