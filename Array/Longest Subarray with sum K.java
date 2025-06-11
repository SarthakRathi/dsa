//Bruteforce

class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        int s = 4;

        int max = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count = 0;
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                count++;
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
