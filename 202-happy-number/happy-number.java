class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int c = 0;
            while (n > 0) {
                int digit = n % 10;
                c += digit * digit;
                n /= 10;
            }
            n = c;
        }
        
        return n==1;

    }
}