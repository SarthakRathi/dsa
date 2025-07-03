class ShipCapacity {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        int low = max(weights);
        int high = sum(weights);
        int ans = high;
        boolean isPossible;

        while (high >= low) {
            int mid = (low + high) / 2;
            isPossible = isPossible(weights, mid, days);
            if (isPossible) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static int max(int[] weights) {
        int max = weights[0];
        for (int i : weights) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int sum(int[] weights) {
        int sum = 0;
        for (int i : weights) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPossible(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int currentWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (currentWeight + weights[i] <= capacity) {
                currentWeight += weights[i];
            } else {
                daysNeeded++;
                currentWeight = weights[i];
            }
        }
        return daysNeeded <= days;
    }
}

// Time Complexity = O(log2 sum) * n