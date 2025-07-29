import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            } else {
                if (brackets.empty())
                    return false;
                char popped = brackets.pop();
                if ((c == ')' && popped == '(') ||
                        (c == '}' && popped == '{') ||
                        (c == ']' && popped == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return brackets.empty();
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)