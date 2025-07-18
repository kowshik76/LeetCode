class Solution {
    public static void director(int i,int j,ArrayList<String> ans,int[][] maze,int[][] visited,String move,int[] di,int[] dj){
        if(i==maze.length-1 && j==maze.length-1){
            ans.add(move);
            return;
        }
        String direction="DLRU";
        for(int ind=0;ind<4;ind++){
            int nexti=i+di[ind];
            int nextj=j+dj[ind];
            if(nexti>=0 && nextj>=0 && nexti<maze.length &&nextj<maze.length && visited[nexti][nextj]!=1 &&maze[nexti][nextj]==1){
                visited[nexti][nextj]=1;
                director(nexti,nextj,ans,maze,visited,move+direction.charAt(ind),di,dj);
                visited[nexti][nextj]=0;
            }
        }
    }
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int[][] visited=new int[maze.length][maze.length];
       
        int[] di={+1,0,0,-1};
        int[] dj={0,-1,1,0};
        ArrayList<String> ans=new ArrayList<>();
        if(maze[0][0]==1){
            
            visited[0][0]=1;
        director(0,0,ans,maze,visited,"",di,dj);
        }
        return ans;
        }
}


