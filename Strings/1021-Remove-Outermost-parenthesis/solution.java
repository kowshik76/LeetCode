class Solution {
    public String removeOuterParentheses(String s) {
        int depth=0;
        String ans="";
       for(char c:s.toCharArray()){
        if(c=='('){
            if(depth > 0) ans+='(';
            depth++;
        }else{
            depth--;
            if(depth!=0){
                ans+=')';
            }
        }
       }
       return ans;
    }
}
