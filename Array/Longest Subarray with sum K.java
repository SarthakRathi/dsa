//Bruteforce

class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        int s = 5;

        int max = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                count = 0;
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                    count++;
                }
                if (sum == s) {
                    if (max < count) {
                        max = count;
                    }
                }
            }
        }
        System.out.print(max);
    }
}

// Time Complexity = O(n**3)
// Space Complexity = O(1)
