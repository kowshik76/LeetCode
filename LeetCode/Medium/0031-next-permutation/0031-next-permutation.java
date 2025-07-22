class Solution {
    public static void reverse(int index,int l,int[] nums){
        while(index<l){
            int temp=nums[index];
            nums[index]=nums[l];
            nums[l]=temp;
            index++;
            l--;
        }
    }
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            Arrays.sort(nums);
            return ;
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[index]){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        reverse(index+1,nums.length-1,nums);
    }
}