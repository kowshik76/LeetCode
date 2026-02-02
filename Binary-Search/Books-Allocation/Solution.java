class Solution {
    public int max(int[] arr){
        int maxi=0;
        for(int i=0;i<arr.length;i++){
             maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
    public int sum(int[] arr){
            int sum=0;
        for(int i=0;i<arr.length;i++){
             sum+=arr[i];
        }
        return sum;
    }
    public boolean allocBooks(int[] arr,int stu,int mid){
        int sum=0;
        int kids=1;
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] <= mid ){
                sum+=arr[i];
            }else{
                kids++;
                sum=arr[i];
            }
        }
            return (kids <= stu);
    }
    public int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k) return -1;
        int l=max(arr);
        int r=sum(arr);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(allocBooks(arr,k,mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
