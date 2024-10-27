class Solution {
    public int compress(char[] chars) {
        int count = 1, totalCount = 0, j = 0;
        char prev = chars[0];  // Initialize prev to the first character
        
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == prev) {
                count++;
            } else {
                // Store the previous character
                chars[j++] = prev;
                totalCount++;

                // Store the count if it's more than 1
                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (char c : countStr.toCharArray()) {
                        chars[j++] = c;
                    }
                    totalCount += countStr.length();
                }

                // Reset for the next character group
                if (i < chars.length) {
                    prev = chars[i];
                    count = 1;
                }
            }
        }

        return totalCount;
    }
}
