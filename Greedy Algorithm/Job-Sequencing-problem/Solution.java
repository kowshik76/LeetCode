class Job{
    int deadline;
    int profit;
    Job(int deadline_,int profit_){
        this.deadline=deadline_;
        this.profit=profit_;
    }
}
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        Job[] arr=new Job[deadline.length];
        for(int i=0;i<deadline.length;i++){
            arr[i]=new Job(deadline[i],profit[i]);
        }
        
        Arrays.sort(arr,(a,b)->{
            return b.profit - a.profit;
        });
        
        
        int maxdeadline=0;
        for(int i=0;i<arr.length;i++){
            maxdeadline=Math.max(maxdeadline,arr[i].deadline);
        }
        int[] slot=new int[maxdeadline+1];
        Arrays.fill(slot,-1);
        int countjobs=0,maxprofit=0;
        for(int i=0;i<deadline.length;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(slot[j] == -1){
                    slot[j]=i;
                    maxprofit+=arr[i].profit;
                    countjobs++;
                    break;
                }
            }
        }
        return new ArrayList<>(List.of(countjobs,maxprofit));
    }
}
