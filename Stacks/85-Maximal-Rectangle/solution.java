class Solution {
    public int MaxHistogram(int[] arr){
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                int element=st.peek();
                st.pop();
                int nse=i;
                int lse=st.empty()?-1 : st.peek();
                maxArea=Math.max(maxArea,arr[element] * (nse-lse-1));
            }
            st.push(i);
        }
        while(!st.empty()){
            int element=st.peek();
            st.pop();
            int nse=arr.length;
            int lse= st.empty() ? -1 : st.peek();
            maxArea=Math.max(maxArea, arr[element]* (nse-lse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        // if(matrix[0].length==0) return 0;
       int MaxRectangle=0;
        int[] prefix=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    prefix[j]=0;
                }else{
                  prefix[j]+=1;
                }
            }
             MaxRectangle=Math.max(MaxRectangle,MaxHistogram(prefix));
        }
        return MaxRectangle;
    }
}
