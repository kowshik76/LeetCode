class Solution {

    public void ms(int low, int mid, int high, int[] arr) {
        ArrayList<Integer> ds = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                ds.add(arr[left]);
                left++;
            } else {
                ds.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            ds.add(arr[left]);
            left++;
        }
        while (right <= high) {
            ds.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = ds.get(i - low);
        }
    }

    public int countPairs(int low, int mid, int high, int[] arr) {
       int count=0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public int merge(int low, int high, int[] arr) {
        int count=0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
       count+= merge(low, mid, arr);
       count+=merge(mid + 1, high, arr);
       count+= countPairs(low, mid, high, arr);
        ms(low, mid, high, arr);
        return count;
    }

    public int reversePairs(int[] nums) {
        return merge(0, nums.length - 1, nums);
    }
}