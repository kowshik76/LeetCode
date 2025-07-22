class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int element1=0;
        int element2=1;
        int count=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(element1==nums[i]){
                count++;
            }else if(element2==nums[i]){
                count2++;
            }else if(count==0){
                element1=nums[i];
                count=1;
            }else if(count2==0){
                element2=nums[i];
                count2=1;
            }else{
                count--;
                count2--;
            }
        }
        count=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(element1==nums[i]){
                count++;
            }else if(element2==nums[i]){
                count2++;
            }
        }
        if(count>(nums.length)/3){
            ans.add(element1);
        }
        if(count2>(nums.length)/3){
            ans.add(element2);
        }
        return ans;
    }
}
