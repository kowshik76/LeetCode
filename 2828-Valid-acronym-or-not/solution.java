class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            String temp=words.get(i);
            if(temp.charAt(1)!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
