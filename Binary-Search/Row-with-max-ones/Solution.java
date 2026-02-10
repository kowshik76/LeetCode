// User function Template for Java

class Solution {
     public int lowerBound(int[] arr){
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if( arr[mid] == 1){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return arr.length-l;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
         int Ones=0;
            int index=-1;
        for(int i=0;i<arr.length;i++){
            int total=lowerBound(arr[i]);
            if(total > Ones){
                Ones=total;
                index=i;
            }
        }
        return index;
    }
}
