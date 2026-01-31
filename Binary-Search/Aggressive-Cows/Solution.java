class Solution {
   
    public boolean iscows(int[] arr,int k,int cowsdis){
        int lastcow=arr[0];
        int countcows=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastcow >= cowsdis){
                countcows++;
                lastcow=arr[i];
            }
            if(countcows >= k){
                return true;
            }
        }
            return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        // code here
        int l=1;
        int r=stalls[stalls.length-1]-stalls[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(iscows(stalls,k,mid)){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return r;
    }
}
