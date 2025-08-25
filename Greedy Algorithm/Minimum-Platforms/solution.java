// User function Template for Java
import java.util.*;
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int l=0,r=0,maxcount=0,count=0;
        while( l < arr.length){
            if( arr[l] <= dep[r]){
                count++;
                l++;
            }else{
                count--;
                r++;
            }
            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
        
    }
}
