class Occurences {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 1, 1 };
        int count = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                if (count < temp) {
                    count = temp;
                    temp = 0;
                }
            }
        }
        if (count < temp) {
            count = temp;
        }
        System.out.println(count);
    }
}
