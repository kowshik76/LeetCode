class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        // code here
       int max=0;
        for(int r=arr.length-1;r>=0;r--){
            if(arr[r]>=max){
                ans.add(arr[r]);
                max=arr[r];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
