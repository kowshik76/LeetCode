class Solution {
    HashMap<Character, Integer> hash = new HashMap<>();
    int ans = 0;

    public int romanToInt(String s) {
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
           int value=hash.get(s.charAt(i));
           if(i<s.length()-1&&value<hash.get(s.charAt(i+1))){
            ans-=value;
           }
           else{
            ans+=value;
           }
        }
        return ans;
    }
}