public class Solution {
    public int[] prevSmaller(int[] A) {
        int[] nums=new int[A.length];
        Stack <Integer> st=new Stack<>();
        for(int i=0;i<A.length;i++){
            int num=A[i];
            while(!st.empty()&&st.peek()>=num){
                st.pop();
            }
          nums[i]=st.empty()?-1:st.peek();
          st.push(num);
        }
        return nums;
    }
}
