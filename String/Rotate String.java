class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        if (s.length() == goal.length()) {
            String concat = s + s;
            if (concat.contains(goal)) {
                System.out.println("It is rotated");
            } else {
                System.out.println("It is not rotated");
            }
        }
    }
}

// Time Complexity = O(n)