class Solution {
    public int rowmax(int[][] arr,int mid){
        int ind=-1;
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][mid] > max){
                max=arr[i][mid];
                ind=i;
            }
        }
        return ind;
    }
    public int[] findPeakGrid(int[][] mat) {
        int l=0;
        int r=mat[0].length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int rowind=rowmax(mat,mid);
            int left= mid-1 >=0 ? mat[rowind][mid-1] : -1;
            int right= mid+1 < mat[0].length ? mat[rowind][mid+1] : -1;
            if(mat[rowind][mid] > left && mat[rowind][mid] > right){
                return new int[]{rowind,mid};
            }else if(mat[rowind][mid] < left){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
