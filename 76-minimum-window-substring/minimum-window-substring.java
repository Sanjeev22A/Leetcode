class Solution {
  
    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        return 26 + (c - 'A');
    }

    boolean checkEqual(int[] map1, int[] map2) {
        for (int i = 0; i < 52; i++) {
            if (map1[i] < map2[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] map2 = new int[52];
        int[] map1 = new int[52];
        for (char c : t.toCharArray()) {
            map2[getIndex(c)]++;
        }

        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        String result = "";

        while (end < s.length()) {
            map1[getIndex(s.charAt(end))]++;
            
            while (checkEqual(map1, map2)) {
                if ((end - start + 1) < minLen) {
                    minLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                map1[getIndex(s.charAt(start))]--;
                start++;
            }
            end++;
        }

        return result;
    }
}
