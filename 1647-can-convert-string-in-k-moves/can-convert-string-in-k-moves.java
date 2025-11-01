class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];  

        for (int i = 0; i < s.length(); i++) {
            int diff = t.charAt(i) - s.charAt(i);
            if (diff < 0) diff += 26;
            if (diff == 0) continue;

            int occurrence = freq[diff]++;  
            int cost = diff + 26 * occurrence;
            if (cost > k) return false;
        }

        return true;
    }
}
