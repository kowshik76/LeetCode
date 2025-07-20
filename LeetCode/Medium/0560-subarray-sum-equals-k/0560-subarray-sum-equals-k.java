class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> prefixLoader=new HashMap<>();
        prefixLoader.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
                if(prefixLoader.containsKey(sum-k)){
                    count+=prefixLoader.get(sum-k);
                }
            prefixLoader.put(sum,prefixLoader.getOrDefault(sum,0)+1);
        }
        return count;
    }
}