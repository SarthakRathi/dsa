class MaximumNesting {
    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";

        int open = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                open--;
            }

            if (count < open) {
                count = open;
            }
        }

        System.out.println(count);
    }
}

// Time Cmplexity = O(n)
