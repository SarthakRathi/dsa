class LargestOddNumber {
    public static void main(String[] args) {
        String num = "7542351161";

        for (int i = num.length(); i > 0; i--) {
            if ((num.charAt(i - 1) - '0') % 2 == 1) {
                System.out.println(num.substring(0, i));
                break;
            }
        }
    }
}
