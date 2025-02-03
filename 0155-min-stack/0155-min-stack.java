class MinStack {
    Stack<Integer> stack;
    Stack<Integer> Minstack;

    public MinStack() {
        stack = new Stack();
        Minstack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if (Minstack.isEmpty() || val <= Minstack.peek()) {
            Minstack.push(val);
        }

    }

    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (!Minstack.isEmpty() && removed == Minstack.peek()) {
                Minstack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return Minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */