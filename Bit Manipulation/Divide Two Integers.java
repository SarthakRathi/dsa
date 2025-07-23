class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        boolean sign = true;
        if (dividend >= 0 && divisor < 0)
            sign = false;
        if (dividend < 0 && divisor > 0)
            sign = false;

        // Handle the specific overflow case first
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt += 1;
            }
            quotient += 1L << cnt;
            n -= (d << cnt);
        }

        long result = sign ? quotient : -quotient;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}

// Time Complexity = O(logn ^ 2)
// Space Complexity = O(1)