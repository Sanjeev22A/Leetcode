class Solution {
    
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] expr = expression.toCharArray();
        for (char c : expr) {
            if (c == ',' || c == '(') {
                continue;
            } else if (c == 't' || c == 'f' || c == '!' || c == '&' || c == '|') {
                stack.push(c);
            } else if (c == ')') {
                boolean hasTrue = false, hasFalse = false;
                while (!stack.isEmpty() && stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    char d = stack.pop();
                    if (d == 't') {
                        hasTrue = true;
                    }
                    if (d == 'f') {
                        hasFalse = true;
                    }
                }
                char top = stack.pop();
                char toPush;
                if (top == '!') {
                    toPush = hasTrue ? 'f' : 't';
                } else if (top == '&') {
                    toPush = hasFalse ? 'f' : 't';
                } else {
                    toPush = hasTrue ? 't' : 'f';
                }
                stack.push(toPush);
            }
        }
        return stack.peek() == 't';
    }
}
