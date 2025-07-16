class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            g[i]=new ArrayList<>();
        }
        for(int[] p:paths){
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        int[] colors=new int[n+1];
        mcolor(1,g,colors);
        return Arrays.copyOfRange(colors,1,n+1);
    }
    public static boolean mcolor(int n,List<Integer>[] g,int[] colors){
        if(n==colors.length){
            return true;
        }
        for(int i=1;i<=4;i++){
            if(isSafe(n,colors,g,i)){
                colors[n]=i;
                if(mcolor(n+1,g,colors)){
                    return true;
                }
                    colors[n]=0;
            }
        }
            return false;
    }
    public static boolean isSafe(int n,int[] colors,List<Integer>[] g,int i){
        for(int nei:g[n]){
            if(colors[nei]==i){
                return false;
            }
        }
        return true;
    }
}