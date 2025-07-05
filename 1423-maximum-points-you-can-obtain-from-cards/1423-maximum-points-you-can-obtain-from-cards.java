class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0,rsum=0,maxScore=0;
        for(int i=0;i<=k-1;i++){
            lsum+=cardPoints[i];
        }
        maxScore=lsum;
       int rindex=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardPoints[i];
            rsum+=cardPoints[rindex];
            rindex--;
            maxScore=Math.max(maxScore,lsum+rsum);
        }
        return maxScore;
    }
}