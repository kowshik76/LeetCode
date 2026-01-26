class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
             int currentdiff=Math.abs(arr[i] - arr[i + 1]);
             mindiff = Math.min(currentdiff,mindiff);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == mindiff) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }
}
