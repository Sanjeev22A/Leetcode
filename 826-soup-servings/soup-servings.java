public class Solution {
    double[][] dp;

    double dfs(int a, int b) {
        if (a <= 0 && b > 0) return 1.0;
        if (a <= 0 && b <= 0) return 0.5;
        if (a > 0 && b <= 0) return 0.0;

        if (dp[a][b] > 0) return dp[a][b];

        return dp[a][b] = 0.25 * dfs(Math.max(a - 4, 0), b) +
                          0.25 * dfs(Math.max(a - 3, 0), Math.max(b - 1, 0)) +
                          0.25 * dfs(Math.max(a - 2, 0), Math.max(b - 2, 0)) +
                          0.25 * dfs(Math.max(a - 1, 0), Math.max(b - 3, 0));
    }

    public double soupServings(int n) {
        if (n >= 5000) return 1.0;
        int units = (n + 24) / 25;
        dp = new double[units + 1][units + 1];
        return dfs(units, units);
    }
}
