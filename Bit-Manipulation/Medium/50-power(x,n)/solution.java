class Solution {
    public double myPow(double x, int n) {
        long power = n;  // use long to handle INT_MIN safely
        double ans = 1;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        while (power > 0) {
            if ((power % 2) == 1) {
                ans *= x;
            }
            x *= x;
            power /= 2;
        }

        return ans;
    }
}
