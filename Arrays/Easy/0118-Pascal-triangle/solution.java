class Solution {
    public static List<Integer> rows(int r) {
        List<Integer> temp = new ArrayList<>();
        int val = 1;
        temp.add(1);
        for (int col = 1; col < r; col++) {
            val = val * (r - col);
            val = val / col;
            temp.add(val);
        }
        return temp;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(rows(i));
        }
        return ans;
    }
}
