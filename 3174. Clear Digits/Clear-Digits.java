class Solution {
    public String clearDigits(String s) {
      Stack <Character> st=new Stack<>();
      StringBuilder sb=new StringBuilder();
       for(int i=0;i<s.length();i++){
            char val=s.charAt(i);
            if(!Character.isDigit(val)){
                st.push(val);
                sb.append(val);
            }else{
                st.pop();
                sb.deleteCharAt(sb.length()-1);
            }
       }
       return sb.toString();
    }
}
