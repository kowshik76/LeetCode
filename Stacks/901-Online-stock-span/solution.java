class StockSpanner {
    Stack<int[]> st;
    int indx;
    public StockSpanner() {
        st=new Stack();
         indx=-1;
    }
    
    public int next(int price) {
         indx++;
        int span=0;
        while(!st.empty() && st.peek()[0] <= price){
            st.pop();
        }
        span= indx - (st.empty() ? -1 : st.peek()[1] );
        st.push(new int[]{price,indx});
    return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
