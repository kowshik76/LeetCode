class Solution {
    public int disfind(int[] arr,double mid){
        int count=0;
        for(int i=1;i<arr.length;i++){
        int distancebtw=(int)((arr[i]-arr[i-1])/mid);
            if((arr[i]-arr[i-1])/mid == distancebtw * mid){
                distancebtw--;
            }
            count+=distancebtw;
        }
        return count;
    }
    public double minMaxDist(int[] stations, int K) {
        // code here
        double l=0;
        double r=0;
        for(int i=1;i<stations.length;i++){
            r=Math.max(r,(double)(stations[i]-stations[i-1]));
        }
        while(r-l > 1e-6){
            double mid=l+(r-l)/(2.0);
            int ans=disfind(stations,mid);
            if(ans > K){
                l=mid;
            }else{
                r=mid;
            }
        }
        return r;
    }
}
