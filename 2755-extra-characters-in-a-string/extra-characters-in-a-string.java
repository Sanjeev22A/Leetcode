import java.util.HashSet;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        // dp[i] represents the minimum number of extra characters starting from index i
        int[] dp = new int[n + 1]; // Make sure to have dp[n] = 0 for boundary condition

        // Initialize a set for quick lookups
        HashSet<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }

        // Fill dp array from the end of the string towards the start
        for (int i = n - 1; i >= 0; i--) {
            // Worst case: treat this character as extra and move on
            dp[i] = dp[i + 1] + 1;

            // Try forming words starting from index i
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (set.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]); // Match found, update dp[i]
                }
            }
        }

        // The answer will be stored at dp[0]
        return dp[0];
    }
}
