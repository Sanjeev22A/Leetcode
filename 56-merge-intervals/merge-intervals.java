class Solution {
     public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] prev = intervals[0]; // Initialize prev to the first interval
        List<int[]> merged = new ArrayList<>();

        // Step 2: Iterate through the intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (prev[1] >= interval[0]) {
                // Overlapping intervals: merge them by updating `prev`
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                // Disjoint intervals: add `prev` to the list and update `prev`
                merged.add(prev);
                prev = interval;
            }
        }

        // Add the last interval
        merged.add(prev);

        // Convert the list to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}