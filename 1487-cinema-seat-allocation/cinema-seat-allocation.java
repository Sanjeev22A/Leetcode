class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();

        int LEFT   = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int MIDDLE = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int RIGHT  = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2-9 matter
            if (col >= 2 && col <= 9) {
                rows.merge(row, 1 << col, (a, b) -> a | b);
            }
        }

        int ans = (n - rows.size()) * 2;

        for (int mask : rows.values()) {
            boolean left = (mask & LEFT) == 0;
            boolean middle = (mask & MIDDLE) == 0;
            boolean right = (mask & RIGHT) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}