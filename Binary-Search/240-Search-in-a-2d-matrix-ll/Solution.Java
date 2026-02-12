class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=matrix[0].length-1;
        while(l < matrix.length && r >= 0){
            if(matrix[l][r] == target){
                return true;
            }else if(matrix[l][r] > target){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
}
