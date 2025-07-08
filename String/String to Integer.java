class StringToInteger {
    public static void main(String[] args) {
        String s = " -042";

        if (s != null && s.length() != 0) {
            int i = 0;
            int n = s.length();

            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            int sign = 1;
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }

            int result = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                result = result * 10 + digit;
                i++;
            }
            System.out.println(sign * result);
        }
    }
}
