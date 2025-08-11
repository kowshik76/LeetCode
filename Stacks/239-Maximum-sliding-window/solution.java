class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr=new int[nums.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekLast() <= i-k){
                dq.removeLast();
            }
            while(!dq.isEmpty() && nums[dq.peekFirst()] <= nums[i]){
                dq.removeFirst();
            }
            dq.push(i);
            if(i>=k-1){
                arr[i-k+1]=nums[dq.peekLast()];
            }
        }
        return arr;
    }
}
