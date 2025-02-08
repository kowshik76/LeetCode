class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int nge[]=new int[nums.length];
        Stack <Integer> st=new Stack<>();
        for(int i=2*nums.length-1;i>=0;i--){
            while(!st.empty()&&st.peek()<=nums[i%nums.length]){
                st.pop();
                  }
                if(i<nums.length){
                    nge[i]=st.empty()?-1:st.peek();
                   
                }
            st.push(nums[i%nums.length]);
          
             
        }
        return nge;
    }
}