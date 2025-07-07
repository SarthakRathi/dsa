class ReverseWordsinString {
    public static void main(String[] args) {
        String s = "a good   example";

        String result = "";
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                temp += s.charAt(i);
            } else {
                result = temp + " " + result;
                temp = "";
            }
        }

        result = temp + " " + result;
        result = result.trim();

        System.out.println(result);
    }
}

// Time Complexity = O(n)