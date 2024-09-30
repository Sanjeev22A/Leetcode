class AllOne {
    

    HashMap<Integer, HashSet<String>> map;
    HashMap<String, Integer> secMap;
    int MAX_FREQUENCY, MIN_FREQUENCY;

    public AllOne() {
        map = new HashMap<>();
        secMap = new HashMap<>();
        MAX_FREQUENCY = Integer.MIN_VALUE;
        MIN_FREQUENCY = Integer.MAX_VALUE;
    }

    private void toHashSet(int count, String key) {
        if (map.containsKey(count)) {
            map.get(count).add(key);
        } else {
            map.put(count, new HashSet<>());
            map.get(count).add(key);
        }
        updateFreqOnAdd(count);
    }

    private void removeFromHashSet(int count, String key) {
        map.get(count).remove(key);
        if (map.get(count).isEmpty()) {
            map.remove(count);
        }
        updateMinMaxFrequencyOnRemove(count);
    }

    public void inc(String key) {
        if (!secMap.containsKey(key)) {
            secMap.put(key, 1);
            toHashSet(1, key);
        } else {
            int currentCount = secMap.get(key);
            removeFromHashSet(currentCount, key);
            secMap.put(key, currentCount + 1);
            toHashSet(currentCount + 1, key);
        }
    }

    public void dec(String key) {
        if (secMap.get(key) == 1) {
            secMap.remove(key);
            removeFromHashSet(1, key);
        } else {
            int currentCount = secMap.get(key);
            removeFromHashSet(currentCount, key);
            secMap.put(key, currentCount - 1);
            toHashSet(currentCount - 1, key);
        }
    }

    public String getMaxKey() {
        if (MAX_FREQUENCY == Integer.MIN_VALUE) return "";
        return map.get(MAX_FREQUENCY).iterator().next();
    }

    public String getMinKey() {
        if (MIN_FREQUENCY == Integer.MAX_VALUE) return "";
        return map.get(MIN_FREQUENCY).iterator().next();
    }

    private void updateFreqOnAdd(int count) {
        if (count > MAX_FREQUENCY) {
            MAX_FREQUENCY = count;
        }
        if (count < MIN_FREQUENCY) {
            MIN_FREQUENCY = count;
        }
    }

    private void updateMinMaxFrequencyOnRemove(int count) {
        if (count == MAX_FREQUENCY && !map.containsKey(count)) {
            MAX_FREQUENCY = map.isEmpty() ? Integer.MIN_VALUE : map.keySet().stream().max(Integer::compare).orElse(MAX_FREQUENCY);
        }
        if (count == MIN_FREQUENCY && !map.containsKey(count)) {
            MIN_FREQUENCY = map.isEmpty() ? Integer.MAX_VALUE : map.keySet().stream().min(Integer::compare).orElse(MIN_FREQUENCY);
        }
    }


}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */