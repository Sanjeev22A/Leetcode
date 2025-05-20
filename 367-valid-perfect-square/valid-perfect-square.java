class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int lo = 2, hi = num / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long m = (long) mid * mid;

            if (m == num) {
                return true;
            } else if (m > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
