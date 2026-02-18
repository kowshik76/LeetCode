class Solution {
    public int upperB(int[] mat,int mid){
        int l=0;
        int r=mat.length-1;
        while(l <=r){
            int mid1=l+(r-l)/2;
            if(mat[mid1] > mid){
                r=mid1-1;
            }else{
                l=mid1+1;
            }
        }
        return l;
    }
    public int blackbox(int[][] mat,int mid){
        int count=0;
        for(int i=0;i<mat.length;i++){
            count+=upperB(mat[i],mid);
        }
        return count;
    }
    public int median(int[][] mat) {
        int max=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<mat.length;i++){
            min=Math.min(mat[i][0],min);
            max=Math.max(mat[i][mat[0].length-1],max);
        }
        // code here
        int l=min;
        int r=max;
            int remnum=(mat.length * mat[0].length)/2;
        while(l <= r){
            int mid=l+(r-l)/2;
            int totaloccur=blackbox(mat,mid);
             if(totaloccur<= remnum ){
                 l=mid+1;
             }else{
                 r=mid-1;
             }
        }
        return l;
    }
}
