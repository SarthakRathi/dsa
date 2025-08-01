import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && (num.charAt(i) - '0' < st.peek() - '0')) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        if (st.isEmpty())
            return "0";

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pollLast());
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}

// Time Complexity = O(n) + O(k)
// Time Complexity = O(2n)