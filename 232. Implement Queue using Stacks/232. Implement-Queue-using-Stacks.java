class MyQueue {
   Stack <Integer> st;
   Stack <Integer> st2;
    int val = 0;
    int val1 = 0;

    public MyQueue() {
 st = new Stack<>();
 st2 = new Stack<>();
    }

    public void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
        } else {
            while (!st.isEmpty()) {
                val = st.pop();
                st2.push(val);
            }
            st.push(x);
            while (!st2.isEmpty()) {
                val1 = st2.pop();
                st.push(val1);
            }
        }
    }

    public int pop() {
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
