import java.util.Stack;

class MinStack {
    Stack<Long> s;
    long min;

    public MinStack() {
        s = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        long v = val;
        if (s.isEmpty()) {
            min = v;
            s.push(v);
        } else {
            if (v >= min) {
                s.push(v);
            } else {
                s.push(2 * v - min);
                min = v;
            }
        }
    }

    public void pop() {
        long top = s.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = s.peek();
        if (top < min) {
            return (int) min;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) min;
    }
}

// Time Complexity = O(1)
// Space Complexity = O(n)