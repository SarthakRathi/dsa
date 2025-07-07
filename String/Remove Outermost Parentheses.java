class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";

        String result = "";
        int balance = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            
            if (balance == 0) {
                result += s.substring(start + 1, i);
                start = i + 1;
            }
        }
        
        System.out.println(result);
    }
}
