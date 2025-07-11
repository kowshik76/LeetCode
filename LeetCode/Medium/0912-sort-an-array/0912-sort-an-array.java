class Solution {
    public static void ms(int[] arr,int high,int mid,int low){
        ArrayList<Integer> ds=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                ds.add(arr[left]);
                left++;
            }else{
               ds.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
                ds.add(arr[left]);
                left++;
        }
        while(right<=high){
               ds.add(arr[right]);
                right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=ds.get(i-low);
        }
    }
    public static void merge(int[] arr,int low,int high){
        if(low==high){
            return;
        }
        int mid=(high+low) /2;
        merge(arr,low,mid);
        merge(arr,mid+1,high);
        ms(arr,high,mid,low);
    }
    public int[] sortArray(int[] nums) {
        int high=nums.length-1;
        int low=0;
        merge(nums,low,high);
        return nums;
    }
}