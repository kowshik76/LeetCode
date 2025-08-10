class Solution {
    public String removeKdigits(String num, int k) {
        Stack <Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.empty() && k>0 && st.peek()-'0' > num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        if(st.empty()) return "0";
        while (k > 0 && !st.empty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        int index=0;
        while( index < sb.length() && sb.charAt(index)=='0'){
            index++;
        }
        String s=sb.substring(index);
        return s.length()==0 ? "0" : s;
    }
}
