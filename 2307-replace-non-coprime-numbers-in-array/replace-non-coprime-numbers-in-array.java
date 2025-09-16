class Solution {
    int GCD(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long LCM(long a, long b) {
        return a / GCD((int)a, (int)b) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        for (int num : nums) {
            long cur = num;
            while (!stack.isEmpty()) {
                long top = stack.peekLast();
                long g = GCD((int)top, (int)cur);
                if (g > 1) {
                    stack.pollLast();
                    cur = LCM(top, cur);
                } else {
                    break;
                }
            }
            stack.addLast(cur);
        }

        
        List<Integer> res = new ArrayList<>();
        for (long x : stack) res.add((int)x);
        return res;
    }
}
