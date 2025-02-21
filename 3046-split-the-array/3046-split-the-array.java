class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        boolean ans = false;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            hs.put(temp, hs.getOrDefault(temp, 0) + 1);
            if (hs.containsKey(temp)) {
                if (hs.get(temp) <= 2) {
                    ans = true;
                } else {
                    return false;
                }
            }
        }
        return ans;
    }
}