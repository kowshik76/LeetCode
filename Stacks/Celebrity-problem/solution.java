class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int top=0;
        int down=mat[0].length-1;
        while(top<down){
            if(mat[top][down]==0 && mat[down][top]==1){
                down--;
            }else if(mat[top][down]==1 && mat[down][top]==0){
                top++;
            }else{
                down--;
                top++;
            }
        } 
        for(int i=0;i<mat.length;i++){
             if (i != top) {
                if (mat[top][i] != 0 || mat[i][top] != 1) {
                    return -1;
                }
            }
        }
        return top;
    }
}
