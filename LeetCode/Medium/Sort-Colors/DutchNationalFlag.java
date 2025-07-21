class Solution {
    public static void swap(int x,int y,int[] arr){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public void sortColors(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(mid<=high){
            if(nums[mid]==0){
                swap(mid,low,nums);
                mid++;
                low++;
            }else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }else{
                mid++;
            }
        }  
    }
}
