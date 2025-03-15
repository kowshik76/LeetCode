class Solution {
    public int maxDepth(String s) {
        Stack <Character> st =new Stack<>();
        int count=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char val=s.charAt(i);
            if(val=='('){
                st.push(val);
                count++;
            }
            else if(val==')'){
                ans=Math.max(ans,count);
                count--;
                st.pop();
            }
        }
        return ans;
    }
}
