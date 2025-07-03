class Bouquets {
    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;

        if (m * k > bloomDay.length) {
            System.out.println(-1);
        } else {

            int low = min(bloomDay);
            int high = max(bloomDay);
            boolean isPossible;
            int minDay = high;

            while (high >= low) {
                int mid = (low + high) / 2;
                isPossible = isPossible(bloomDay, mid, m, k);
                if (isPossible) {
                    minDay = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(minDay);
        }
    }

    public static int max(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int min(int[] nums) {
        int min = nums[0];
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int counter = 0;
        int total = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                counter++;
            } else {
                total += counter / k;
                counter = 0;
            }
        }
        total += counter / k;
        if (total >= m) {
            return true;
        } else {
            return false;
        }
    }
}
