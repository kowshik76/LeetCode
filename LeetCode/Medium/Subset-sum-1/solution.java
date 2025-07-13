// User function Template for Java//User function Template for Java
class Solution {
    public static void isSub(int ind,int[] arr,ArrayList<Integer> ans,int sum){
        if(ind==arr.length){
            ans.add(sum);
            return;
        }
        isSub(ind+1,arr,ans,sum+arr[ind]);
        
        isSub(ind+1,arr,ans,sum);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(arr);
        isSub(0,arr,ans,0);
        return ans;
    }
}
