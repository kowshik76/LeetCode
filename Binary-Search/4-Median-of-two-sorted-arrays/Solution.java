class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
          if ((nums1 == null || nums1.length == 0) && 
            (nums2 == null || nums2.length == 0)) return 0.0;

        if (nums1 == null || nums1.length == 0) {
            int n = nums2.length;
            if (n % 2 == 1) return nums2[n / 2];
            return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
        }

        if (nums2 == null || nums2.length == 0) {
            int n = nums1.length;
            if (n % 2 == 1) return nums1[n / 2];
            return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
        }
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int l=0,r=n1;
        int left=(n1+n2+1)/2;
        int n=(n1+n2);
        while(l<=r){
            int mid1=l+(r-l)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if (mid1 > 0) l1 = nums1[mid1 - 1];
            if (mid2 > 0) l2 = nums2[mid2 - 1];
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if(l1 <= r2 && l2 <=r1) {
                if(n %2 ==1){
                 return (double)Math.max(l1,l2);
                }
              return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }else if(l1 > r2) r=mid1-1;
            else l=mid1+1;
        }
        return 0;
    }
}
