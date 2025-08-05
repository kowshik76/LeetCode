class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        int ans = 0;
        boolean sign = true;

        if (divisor == dividend) return 1;
        if (dividend <= 0 && divisor > 0) {
            sign = false;
        } else if (dividend >= 0 && divisor < 0) {
            sign = false;
        }

        long divi = Math.abs((long) dividend);
        long visor = Math.abs((long) divisor);

        while (divi >= visor) {
            count = 0;
            // Limit count to 31 to avoid 1 << 32 (which overflows)
            while (count < 31 && divi >= visor * (1L << (count + 1))) {
                count++;
            }
            ans += 1 << count;
            divi -= visor * (1L << count);
        }

        if (ans == (1 << 31) && sign) {
            return Integer.MAX_VALUE;
        }
        if (ans == (1 << 31) && !sign) {
            return Integer.MIN_VALUE;
        }

        return sign ? ans : -ans;
    }
}
