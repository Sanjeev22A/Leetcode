/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) return null;

        // If the input is a single integer (no brackets)
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;
        int num = 0;
        boolean negative = false;
        boolean hasNumber = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-') {
                negative = true;
            } else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                hasNumber = true;
            } else if (ch == '[') {
                NestedInteger ni = new NestedInteger();
                if (!stack.isEmpty()) {
                    stack.peek().add(ni);
                }
                stack.push(ni);
            } else if (ch == ',' || ch == ']') {
                if (hasNumber) {
                    if (negative) num *= -1;
                    stack.peek().add(new NestedInteger(num));
                }
                // Reset the number state
                num = 0;
                negative = false;
                hasNumber = false;

                if (ch == ']') {
                    current = stack.pop();
                }
            }
        }

        return current;
    }
}
