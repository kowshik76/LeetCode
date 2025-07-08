class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int l = 0, r = 0;
        int minlen = Integer.MAX_VALUE;
        int count = 0;
        int stindex = -1;
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }
        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
            while (count == t.length()) {
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    stindex = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;

            }
            r++;
        }
        return stindex == -1 ? "" : s.substring(stindex, stindex + minlen);
    }
}