class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=(matrix.length * matrix[0].length)-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int val=matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(val == target){
                return true;
            }else if(val > target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
