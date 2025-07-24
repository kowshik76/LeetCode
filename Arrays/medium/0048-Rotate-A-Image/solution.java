class Solution {
    public static void reverse(int[] matrix){
        int l=0,r=matrix.length-1;
        while(l<r){
            int temp=matrix[l];
            matrix[l]=matrix[r];
            matrix[r]=temp;
            l++;
            r--;
        }
    }
    public void rotate(int[][] matrix) {
      //transpose the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
          //reverse the rows
            reverse(matrix[i]);
        }
    }
}
