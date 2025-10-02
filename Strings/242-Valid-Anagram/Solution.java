class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
       HashMap<Character,Integer> hs=new HashMap<>();
       HashMap<Character,Integer> ht=new HashMap<>();
       for(int i=0;i<s.length();i++){
        hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
        ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
       }
       for(char cs:hs.keySet()){
        if(!ht.containsKey(cs)){
            return false;
        }
        if(!hs.get(cs).equals(ht.get(cs))) return false;
       }
       return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
       HashMap<Character,Integer> hs=new HashMap<>();
       HashMap<Character,Integer> ht=new HashMap<>();
       for(int i=0;i<s.length();i++){
        hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
        ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
       }
       return hs.equals(ht);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }
}
