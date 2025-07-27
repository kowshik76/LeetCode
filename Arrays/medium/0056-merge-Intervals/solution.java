class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ansList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(ansList.size()==0 || intervals[i][0]>ansList.get(ansList.size()-1)[1]){
                ansList.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                ansList.get(ansList.size()-1)[1]=Math.max(ansList.get(ansList.size()-1)[1],intervals[i][1]);
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
