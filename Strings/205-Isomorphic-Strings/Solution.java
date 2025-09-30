class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> h1 = new HashMap<>();
        HashMap<Character, Character> h2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ss = s.charAt(i);
            char st = t.charAt(i);
            if (h1.containsKey(ss)) {
                if (h1.get(ss) != st) {
                    return false;
                }
            } else {
                h1.put(ss, st);
            }
            if (h2.containsKey(st)) {
                if (h2.get(st) != ss) {
                    return false;
                }
            } else {
                h2.put(st, ss);
            }
        }
        return true;
    }
}
