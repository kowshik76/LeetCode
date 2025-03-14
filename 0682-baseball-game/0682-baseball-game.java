class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        Stack <Integer> st=new Stack<>();
        int n=operations.length;
        for(int i=0;i<n;i++){
            String var=operations[i];
            if(var.equals("C") && !st.isEmpty()){
                st.pop();
            }
            else if(var.equals("+")){
                int temp1=st.pop();
                int temp2=st.peek();
                st.push(temp1);;
                st.push(temp1+temp2);
            }
            else if(var.equals("D")){
                st.push(st.peek()*2);
            }else{
                st.push(Integer.parseInt(var));
            }
        }
        while(!st.isEmpty()){
             sum+=st.pop();
        }
        return sum;
    }
}