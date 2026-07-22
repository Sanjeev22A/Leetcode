class Solution {
    public String findLatestTime(String s) {
        StringBuilder res = new StringBuilder();

        char c = s.charAt(0);

        // First hour digit
        if (s.charAt(0) == '?') {
            if (s.charAt(1) == '?' || s.charAt(1) <= '1') {
                res.append('1');
                c = '1';
            } else {
                res.append('0');
                c = '0';
            }
        } else {
            res.append(c);
        }

        // Second hour digit
        if (s.charAt(1) == '?') {
            if (c == '1') {
                res.append('1');
            } else {
                res.append('9');
            }
        } else {
            res.append(s.charAt(1));
        }

        res.append(':');

        // First minute digit
        if (s.charAt(3) == '?') {
            res.append('5');
        } else {
            res.append(s.charAt(3));
        }

        // Second minute digit
        if (s.charAt(4) == '?') {
            res.append('9');
        } else {
            res.append(s.charAt(4));
        }

        return res.toString();
    }
}