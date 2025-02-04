class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> s1=new Stack<>();
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            int num=nums2[i];
            while(!s1.isEmpty()&&s1.peek()<=num){
                s1.pop();
            }
            if(s1.isEmpty()){
                hash.put(num,-1);
              
            }
             else{
                hash.put(num,s1.peek());
                
             }
              s1.push(num);
        }
        int nums[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            nums[i]=hash.getOrDefault(nums1[i],-1);
        }
        return nums;
    }
}