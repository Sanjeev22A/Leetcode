class Solution {
    boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (!isAlphanumeric(s.charAt(start))) {
                start++;
            } else if (!isAlphanumeric(s.charAt(end))) {
                end--;
            } else if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
