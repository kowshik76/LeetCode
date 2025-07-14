class Solution {
    public static List<String> regenerate(char[][] board){
        List<String> convert=new LinkedList<String>();
        for(int i=0;i<board.length;i++){
            String S=new String(board[i]);
            convert.add(S);
        }
        return convert;
    }
    public static void queenclash(int col,int[] leftrow,int[] lowerdiagonal,int[] upperdiagonal,List<List<String>> ans,char[][] board){
        if(col==board.length){
            ans.add(regenerate(board));
            return;
        }
        for(int i=0;i<board.length;i++){ //i - rows
            if(leftrow[i]==0 && lowerdiagonal[i+col]==0 && upperdiagonal[board.length-1 + col-i]==0){
                board[i][col]='Q';
                //Hashing trick
                leftrow[i]=1;
                //lower formula rows+col
                lowerdiagonal[i+col]=1;
                //formula for upper - total length + col-rows
                upperdiagonal[board.length-1 + col -i]=1;
                queenclash(col+1,leftrow,lowerdiagonal,upperdiagonal,ans,board);
               //revert hashing for backtrack
                board[i][col]='.';
                leftrow[i]=0;
                lowerdiagonal[i+col]=0;
                upperdiagonal[board.length-1 + col -i]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int[] leftrow=new int[n];
        //formula for upper and lower diagonal 2*n-1
        int[] lowerdiagonal=new int[2*n-1];
        int[] upperdiagonal=new int[2*n-1];
        queenclash(0,leftrow,lowerdiagonal,upperdiagonal,ans,board);
        return ans;
    }
}