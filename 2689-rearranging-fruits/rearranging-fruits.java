class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new TreeMap<>();
        int n = basket1.length;
        for (int i = 0; i < n; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
        }

        List<Integer> excess = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int value = e.getValue();
            if (value % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(value) / 2; i++) {
                excess.add(e.getKey());
            }
        }

        Collections.sort(excess);
        long minVal = Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());
        long ans = 0;
        for (int i = 0; i < excess.size() / 2; i++) {
            ans += Math.min(excess.get(i), 2 * minVal);
        }

        return ans;
    }
}
