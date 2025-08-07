class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while (!st.empty() && st.peek() < Math.abs(asteroids[i]) && st.peek() > 0) {
                    st.pop();
                }
                if ( !st.empty() && Math.abs(asteroids[i]) == st.peek() && st.peek() > 0) {
                    st.pop();
                } else if (st.empty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        int[] arr = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }
}
