// Optimal

class Stocks {
    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };

        int min = nums[0];
        int maxProfit = 0;

        for (int i = 1; i < nums.length; i++) {
            int profit = nums[i] - min;
            maxProfit = Math.max(profit, profit);
            min = Math.min(nums[i], min);
        }

        System.out.println(maxProfit);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)