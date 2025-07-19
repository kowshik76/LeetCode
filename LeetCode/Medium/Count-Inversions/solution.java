class Solution {
    public static int  ms(int[] arr,int low,int mid,int high){
        ArrayList<Integer> ds=new ArrayList<>();
        int count=0;
        int l=low;
        int r=mid+1;
        while(l<=mid && r<=high){
            if(arr[l]<=arr[r]){
                ds.add(arr[l]);
                l++;
            }else{
                ds.add(arr[r]);
                count+=(mid-l+1);
                r++;
            }
        }
        while(l<=mid){
             ds.add(arr[l]);
                l++;
        }
        while(r<=high){
             ds.add(arr[r]);
                r++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=ds.get(i-low);
        }
        return count;
    }
    public static int merge(int[] arr,int low,int high){
        int count=0;
        if(low==high){
            return count;
        }
        int mid=(high+low)/2;
       count+= merge(arr,low,mid);
        count+=merge(arr,mid+1,high);
       count+=ms(arr,low,mid,high);
       return count;
    }
    static int inversionCount(int arr[]) {
        // Code Here
        int low=0;
        int high=arr.length-1;
       return  merge(arr,low,high);
    }
}
