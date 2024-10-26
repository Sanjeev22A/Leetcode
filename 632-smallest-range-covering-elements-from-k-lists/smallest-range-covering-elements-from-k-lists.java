class Solution {
    class Pair {
        int val, group;
        Pair(int val, int group) {
            this.val = val;
            this.group = group;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        // Step 1: Flatten all the elements into a list of pairs
        List<Pair> main = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int a : nums.get(i)) {
                main.add(new Pair(a, i));
            }
        }

        // Step 2: Sort the pairs by 'val', and if 'val' is the same, by 'group'
        Collections.sort(main, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.val != b.val) {
                    return a.val - b.val;
                } else {
                    return a.group - b.group;
                }
            }
        });

        // Step 3: Sliding window to find the smallest range
        int[] groupCount = new int[nums.size()]; // Tracks how many elements from each group are in the window
        int groupInWindow = 0; // Number of groups currently covered in the window
        int left = 0; // Left pointer for the window
        int minRange = Integer.MAX_VALUE; // Minimum range found
        int start = -1, end = -1; // To store the result range

        // Traverse through the sorted pairs using the right pointer
        for (int right = 0; right < main.size(); right++) {
            Pair cur = main.get(right);
            if (groupCount[cur.group] == 0) {
                groupInWindow++; // New group is included in the window
            }
            groupCount[cur.group]++;

            // Shrink the window from the left as much as possible while maintaining at least one element from each group
            while (groupInWindow == nums.size()) {
                Pair leftPair = main.get(left);

                // Update the minimum range if the current window is smaller
                if (cur.val - leftPair.val < minRange) {
                    minRange = cur.val - leftPair.val;
                    start = leftPair.val;
                    end = cur.val;
                }

                // Remove the leftmost element and shrink the window
                groupCount[leftPair.group]--;
                if (groupCount[leftPair.group] == 0) {
                    groupInWindow--; // Group is no longer fully covered
                }
                left++; // Move the left pointer to shrink the window
            }
        }

        // Step 4: Return the result range
        return new int[]{start, end};
    }
}
