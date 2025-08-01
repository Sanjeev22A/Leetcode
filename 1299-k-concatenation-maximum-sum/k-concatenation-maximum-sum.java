class Solution {
    int mod = (int)1e9 + 7;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long max = Long.MIN_VALUE;
        long ans = 0;
        long maxEnding = 0;

        int n = arr.length;
        int limit = k > 2 ? 2 * n : k * n; 

        for (int i = 0; i < limit; i++) {
            int idx = i % n;
            maxEnding = Math.max(maxEnding + arr[idx], (long) arr[idx]);
            ans = Math.max(ans, maxEnding);
            max = Math.max(max, (long) arr[idx]);
        }

        if (max < 0) return 0;

        long totalSum = 0;
        for (int num : arr) totalSum += num;

        if (k > 2 && totalSum > 0) {
            ans = (ans + ((k - 2) * totalSum) % mod) % mod;
        }

        return (int)(ans % mod);
    }
}
